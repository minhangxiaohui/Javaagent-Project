package priv.ga0weIinstrumentationRetransform;

import com.sun.tools.attach.VirtualMachine;

public class AttachRetransform {
    public static void main(String[] args) throws Exception {
        VirtualMachine vm = VirtualMachine.attach("17976");
        vm.loadAgent("D:\\githubprogram\\Testforjavaagent\\target\\Testforjavaagent-1.0-SNAPSHOT.jar");
    }
}
