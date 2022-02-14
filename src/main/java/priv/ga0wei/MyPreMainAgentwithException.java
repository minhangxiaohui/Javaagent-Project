package priv.ga0wei;

import java.io.IOException;
import java.lang.instrument.Instrumentation;

public class MyPreMainAgentwithException {
    public static void premain(String agentArgs, Instrumentation ins){
        System.out.println("agent print with "+agentArgs);
        try {
            Runtime.getRuntime().exec("calcxxx");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
