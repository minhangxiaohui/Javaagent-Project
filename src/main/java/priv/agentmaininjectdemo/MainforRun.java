package priv.agentmaininjectdemo;

public class MainforRun {
    public static void main(String[] args) throws Exception{
        while (true){
            new Peoples().say();
            Thread.sleep(5000);
        }

    }
}
