package priv.ga0we1instrumentation;

import java.lang.instrument.Instrumentation;

public class TransfromAgent {
    public static void premain(String agentArgs, Instrumentation ins){
        ins.addTransformer(new FruitTransformer());
    }
}
