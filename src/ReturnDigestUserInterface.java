import javax.xml.bind.DatatypeConverter;

/**
 * @author tombisnis@yahoo.com
 */
public class ReturnDigestUserInterface {
    public static void main(String[] args) {
        for(String filename : args){
            ReturnDigest returnDigest = new ReturnDigest(filename);
            returnDigest.start();
            
            StringBuilder stringBuilder = new StringBuilder(filename);
            stringBuilder.append(": ");
            
            byte[] digest = returnDigest.getDigest();
            stringBuilder.append(DatatypeConverter.printHexBinary(digest));
            
            System.out.println(stringBuilder);
        }
    }
}