package priv.agentmaininjectdemo;

import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;

public class Test {
    public static void main(String[] args) {
//        获取当前jvm进程的pid
        String name = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];

        ClassLoadingMXBean classLoadingMXBean = ManagementFactory.getClassLoadingMXBean();
        System.out.println("已加载的类："+classLoadingMXBean.getLoadedClassCount());
        System.out.println(name);
    }
}
