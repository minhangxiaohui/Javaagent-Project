package priv.ga0wei;

import java.lang.instrument.Instrumentation;

public class MyAgentMain {
    public  static  void agentmain(String agentArgs, Instrumentation instrumentation){
        System.out.println("agentmain print with" + agentArgs);
    }
}
