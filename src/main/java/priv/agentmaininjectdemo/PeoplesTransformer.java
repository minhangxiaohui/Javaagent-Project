package priv.agentmaininjectdemo;

import java.io.*;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class PeoplesTransformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if(!className.startsWith("priv/agentmaininjectdemo/Peoples"))
        {
            return  classfileBuffer;
        }
        System.out.println(className);
        String filename = "D:\\githubprogram\\Testforjavaagent\\Peoples2.class";

        try {
            File file =new File(filename);
            InputStream fis = new FileInputStream(file);
            long length = file.length();
            byte[] bytess = new byte[(int)length];

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int b ;
            while ((b=fis.read(bytess))!=-1){
                bos.write(bytess,0,b);
            }
            return bytess;
        } catch (IOException e) {
            e.printStackTrace();
            return  null;
        }


    }
}
