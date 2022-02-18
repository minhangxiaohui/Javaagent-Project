package priv.agentmaininjectdemo;



import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

public class Agentthing {
    public static void agentmain(String agentArgs, Instrumentation inst)
            throws UnmodifiableClassException {
        inst.addTransformer(new PeoplesTransformer(),true);
        inst.retransformClasses(Peoples.class);
        System.out.println(inst.getAllLoadedClasses());
        System.out.println("retransform success");
    }
}
