package javatpoint;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author tombisnis@yahoo.com
 */
public class MyServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6666);
            Socket socket = serverSocket.accept();
            
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            
            String s = dataInputStream.readUTF();
            
            System.out.println("Message >>> "+s);
            
            serverSocket.close();
        } catch (Exception exception) {
            Logger.getLogger(MyServer.class.getName()).log(Level.SEVERE, null, exception);
        }
    }
}