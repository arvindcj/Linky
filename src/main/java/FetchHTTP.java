import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FetchHTTP {
    StringBuilder htmlResponse;
    URL url;
    HttpURLConnection conn;
    BufferedReader rd;
    String line;
    
   public String fetchHTML(String urlToRead) throws Exception {
      htmlResponse = new StringBuilder();

      url = new URL(urlToRead);
      conn = (HttpURLConnection) url.openConnection();

      conn.setRequestMethod("GET");

      try {
	  rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
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
