package priv.findmemshell;

import com.sun.tools.attach.VirtualMachine;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Findattach {
    public static void main(String[] args) throws Exception{
        String pid = getjarpid().trim();
        System.out.println(pid);
        VirtualMachine vm = VirtualMachine.attach(pid);
        vm.loadAgent("D:\\githubprogram\\Testforjavaagent\\Findagent-2.0-SNAPSHOT.jar");
    }
    private static String getjarpid() throws Exception{
        Process ps = Runtime.getRuntime().exec("jps");
        InputStream is = ps.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader bis = new BufferedReader(isr);
        String line;
        StringBuilder sb = new StringBuilder();
        String result = null;
        while((line=bis.readLine())!=null){
            sb.append(line+";");
        }
        String  [] xx= sb.toString().split(";");
        for (String x : xx){
            String name = "Bootstrap";
            if (x.contains(name))
            {
                result=x.substring(0,x.length()-name.length());
            }
        }
        return result;
    }
}
