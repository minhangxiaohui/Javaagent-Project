package priv.ga0wei;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;

public class AttachTest {
    public static void main(String[] args) {

        try {
            VirtualMachine virtualMachine =VirtualMachine.attach("12596");
            virtualMachine.loadAgent("D:\\githubprogram\\Testforjavaagent\\target\\Testforjavaagent-1.0-SNAPSHOT.jar","paramter");
        } catch (AttachNotSupportedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AgentLoadException e) {
            e.printStackTrace();
        } catch (AgentInitializationException e) {
            e.printStackTrace();
        }
    }
}
