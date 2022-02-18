package priv.agentmaininjectdemo;

import com.sun.tools.attach.VirtualMachine;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Attachthings {
    public static void main(String[] args) throws Exception{

//        System.out.println(getjarpid());
        //agentfordemo-1.0-SNAPSHOT.jar
        String pid = getjarpid().trim();
//        System.out.println(pid);
        VirtualMachine vm = VirtualMachine.attach(pid);
        vm.loadAgent("D:\\githubprogram\\Testforjavaagent\\agentfordemo-1.0-SNAPSHOT.jar");
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
            if (x.contains("jar"))
            {
                result=x.substring(0,x.length()-3);
            }
        }
        return result;
    }
}
