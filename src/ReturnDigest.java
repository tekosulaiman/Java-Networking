import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author tombisnis@yahoo.com
 */
public class ReturnDigest extends Thread{
    private String filename;
    private byte[] digest;
    
    public ReturnDigest(String filename){
        this.filename = filename;
    }
    
    @Override
    public void run(){
        try {
            FileInputStream fileInputStream = new FileInputStream(filename);
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            DigestInputStream digestInputStream = new DigestInputStream(fileInputStream, messageDigest);
            
            while(digestInputStream.read() != -1);
            digestInputStream.close();
            
            digest = messageDigest.digest();
            
        }catch (IOException iOException) {
            Logger.getLogger(ReturnDigest.class.getName()).log(Level.SEVERE, null, iOException);
        }catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            Logger.getLogger(ReturnDigest.class.getName()).log(Level.SEVERE, null, noSuchAlgorithmException);
        }
    }
    
    public byte[] getDigest(){
        return digest; 
    }
}