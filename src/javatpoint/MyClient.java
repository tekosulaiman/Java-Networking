package javatpoint;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author tombisnis@yahoo.com
 */
public class MyClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 6666);
            
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF("Get in to Server!");
            dataOutputStream.flush();
            dataOutputStream.close();
            
            socket.close();
            
        } catch (Exception exception) {
            Logger.getLogger(MyClient.class.getName()).log(Level.SEVERE, null, exception);
        }
    }
}