package vogella;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author tombisnis@yahoo.com
 */
public class ReadMimeType {
    public static void main(String[] args) throws IOException {
        String URLText = "http://teko-sulaiman.blogspot.com";
        
        URL url = new URL(URLText);
        
        String ContentType = ((HttpURLConnection)url.openConnection()).getContentType();
        
        System.out.println(ContentType);
    }
}