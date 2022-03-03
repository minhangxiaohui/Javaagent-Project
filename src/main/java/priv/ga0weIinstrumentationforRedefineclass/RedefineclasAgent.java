package priv.ga0weIinstrumentationforRedefineclass;

import java.io.*;
import java.lang.instrument.ClassDefinition;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

public class RedefineclasAgent {

    public static void  premain(String agentArgs, Instrumentation inst) throws UnmodifiableClassException, ClassNotFoundException, IOException {
        String filename = "D:\\githubprogram\\Testforjavaagent\\Fruit3.class";//注意这里的class文件和下面的路径要一致
        byte [] bytes = getbytesformClass(filename);
        ClassDefinition definition = new ClassDefinition(Fruit.class,bytes);
        inst.redefineClasses(definition);
    }
    /**
     * 将class字节码文件转化成bytes
     * @param filename
     * @return bytes
     * @throws Exception
     */
    public static byte[] getbytesformClass(String filename) throws IOException {
        File file =new File(filename);
        byte [] result = new byte[(int)file.length()];
        InputStream is = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int b;
        while ((b=is.read(result))!=-1){
            bos.write(result,0,b);
        }
        return result;
    }
}
