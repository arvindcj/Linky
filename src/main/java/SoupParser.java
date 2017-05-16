import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jsoup.select.*;
import org.jsoup.nodes.*;

import java.io.IOException;

class SoupParser
    extends Model {

    String url;
    FetchHTTP fetchData;
    String responseHTML;
    Document document;

    public void jk() {
	Linky.logger.info("sdfsdfsddsfs");
    }
    
    public void parseHTML(String url) {
	try {
	    Linky.logger.info("*** Input URL ***");
	    Linky.logger.info(url);
	    fetchData = new FetchHTTP();
	    responseHTML = fetchData.fetchHTML(url);
	    Linky.logger.info(responseHTML);
	} catch (Exception e) {}
	document = Jsoup.parse(responseHTML);
	
	document.traverse(new NodeVisitor() {
		public void head(Node node, int depth) {
	    
		    System.out.println(node.nodeName().toString() );
		    //if(node.nodeName() == "#text") {
		    //	System.out.println(node.toString());
		    //	System.out.println("Depth : " + depth);
		    //}
		}
		
		public void tail(Node node, int depth) {
		    System.out.println(node.nodeName().toString());
		}
	    });
    }
}
