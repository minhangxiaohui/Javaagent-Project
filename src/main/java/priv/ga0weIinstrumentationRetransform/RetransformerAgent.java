package priv.ga0weIinstrumentationRetransform;


import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

public class RetransformerAgent {
    public static void agentmain(String agentArgs, Instrumentation inst)
            throws UnmodifiableClassException {
        inst.addTransformer(new PeopleTransformer(),true);
        inst.retransformClasses(People.class);
        System.out.println(inst.getAllLoadedClasses());
        System.out.println("retransform success");
    }
}
