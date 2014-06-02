package vogella;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author tombisnis@yahoo.com
 */
public class ReadWebPage {
    public static void main(String[] args){
        String URLText = "http://teko-sulaiman.blogspot.com";
        BufferedReader bufferedReader = null;
        
        try {
            URL url = new URL(URLText);
            bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            
            String InputLine;
            
            while((InputLine = bufferedReader.readLine()) != null){
                System.out.println(InputLine);
            }
        } catch (Exception exception) {
            Logger.getLogger(ReadWebPage.class.getName()).log(Level.SEVERE, null, exception);
        } finally {
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException iOException) {
                    Logger.getLogger(ReadWebPage.class.getName()).log(Level.SEVERE, null, iOException);
                }
            }
        }
    }
}