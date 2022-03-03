package priv.findmemshell;


import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;


public class Findagent {
    public static void agentmain(String agentArgs, Instrumentation inst) throws UnmodifiableClassException {
        inst.addTransformer(new CatalinaTransformer(),true);
        System.out.println(inst.getAllLoadedClasses());
        Class[] xx = inst.getAllLoadedClasses();
        for (Class x :xx)
        {
            if (x.getName().equals("org.apache.catalina.core.ApplicationFilterChain")){
                inst.retransformClasses(x);
            }
        }

        System.out.println("retransform success");
    }
}
