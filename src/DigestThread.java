import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;

/**
 * @author tombisnis@yahoo.com
 */
public class DigestThread extends Thread{
    private String filename;
    
    public DigestThread(String filename){
        this.filename = filename;
    }
    
    @Override
    public void run(){
        try {

            FileInputStream fileInputStream;
            fileInputStream = new FileInputStream(filename);
        
            MessageDigest messageDigest = MessageDigest.getInstance("SH-256");
            DigestInputStream digestInputStream = new DigestInputStream(fileInputStream, messageDigest);

            while (digestInputStream.read() != -1);
                digestInputStream.close();

            byte[] bsDigest = messageDigest.digest();

            StringBuilder stringBuilder = new StringBuilder(filename);
            stringBuilder.append(": ");
            stringBuilder.append(DatatypeConverter.printHexBinary(bsDigest));

            System.out.println(bsDigest);
        } catch (IOException iOException) {
            Logger.getLogger(DigestThread.class.getName()).log(Level.SEVERE, null, iOException);
        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            Logger.getLogger(DigestThread.class.getName()).log(Level.SEVERE, null, noSuchAlgorithmException);
        }
    }
    
    public static void main(String[] args) {
        for(String filename : args){
            Thread thread = new DigestThread(filename);
            
            thread.start();
        }
    }
}