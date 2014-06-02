package vogella;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author tombisnis@yahoo.com
 */
public class ReadReturnCode {
    public static void main(String[] args) throws IOException {
        String URLText = "http://teko-sulaiman.blogspot.com";
        
        URL url = new URL(URLText);
        
        int ResponseCode = ((HttpURLConnection)url.openConnection()).getResponseCode();
        
        System.out.println(ResponseCode);
    }
}