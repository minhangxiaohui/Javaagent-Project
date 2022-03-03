package priv.ga0wei;

import java.lang.instrument.Instrumentation;

public class MyPreMainAgent {
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("premain start");
        System.out.println("args:"+agentArgs);
    }
}
