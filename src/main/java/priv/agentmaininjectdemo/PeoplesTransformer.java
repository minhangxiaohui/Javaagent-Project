package priv.agentmaininjectdemo;

import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

public class PeoplesTransformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        if(!className.startsWith("priv/agentmaininjectdemo/Peoples"))
        {
            return  classfileBuffer;
        }

        try{
        ClassPool cp = ClassPool.getDefault();
        ClassClassPath classPath = new ClassClassPath(classBeingRedefined);  //get current class's classpath
        cp.insertClassPath(classPath);  //add the classpath to classpool
        CtClass cc = cp.get("priv.agentmaininjectdemo.Peoples");
        CtMethod m = cc.getDeclaredMethod("say");
            System.out.println("changing class method to add some code ........");
        m.addLocalVariable("elapsedTime", CtClass.longType);
        m.insertBefore("System.out.println(\"injected by agent\");");
        byte[] byteCode = cc.toBytecode();
        cc.detach();
        return byteCode;
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("warning");
            return null;
        }
    }
}
