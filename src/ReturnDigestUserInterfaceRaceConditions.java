import javax.xml.bind.DatatypeConverter;

/**
 * @author tombisnis@yahoo.com
 */
public class ReturnDigestUserInterfaceRaceConditions {
    public static void main(String[] args) {
        ReturnDigest[] digests = new ReturnDigest[args.length];
        
        for(int i = 0; i < args.length; i++){
            //Kalkulasi Digest
            digests[i] = new ReturnDigest(args[i]);
            digests[i].start();
        }
        
        for(int i = 0; i < args.length; i++){
            //Print Hasil
            StringBuffer stringBuffer = new StringBuffer(args[i]);
            stringBuffer.append(": ");
            
            byte[] digest = digests[i].getDigest();
            stringBuffer.append(DatatypeConverter.printHexBinary(digest));
            
            System.out.println(stringBuffer);
        }
    }
}