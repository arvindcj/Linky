import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/* HTTP Fetcher HTML
   1. Setup URL
   2. get HTML from remote server.
   3. build HTML response string.
   4. return HTMl response.
 */
public class FetchHTTP {

    StringBuilder htmlResponse;
    URL url;
    HttpURLConnection connect;
    BufferedReader rd;
    String line;
    
   public String fetchHTML(String urlString)
       throws Exception {
      
      htmlResponse = new StringBuilder();

      url = new URL(urlString);
      connect = (HttpURLConnection) url.openConnection();
      connect.setRequestMethod("GET");

      try {
	  rd = new BufferedReader(new InputStreamReader(connect.getInputStream()));
      } catch (Exception e) {
	  Linky.logger.info(e.getMessage());
      }

      while ((line = rd.readLine()) != null) {
         htmlResponse.append(line);
      }

      rd.close();
      return htmlResponse.toString();
   }

}
