package priv.findmemshell;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class CatalinaTransformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        System.out.println("classname is "+className);
        if (className.contains("shell")){
            System.out.println(className +" is a memshell");
            return classfileBuffer;
        }else {
//        System.out.println(className);
            return classfileBuffer;
        }
    }
}
