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

class SoupParser {

    String file_name;
    FetchHTTP fetchH;
    String rawHTML;
    Document doc;
    
    SoupParser(String file_name) {
    Linky.logger.info(file_name);
	this.file_name = file_name;
	try {
	    FetchHTTP fetchH = new FetchHTTP();
	    rawHTML = fetchH.fetchHTML(this.file_name);
	    //Linky.logger.info(rawHTML);
	} catch (Exception e) {
	}
     }

    public void run() {
	//	Linky.logger.info(rawHTML);
	  doc = Jsoup.parse(rawHTML);
	  Linky.logger.info(doc.title());
    }

    public void elementsHTML() {
	doc.traverse(new NodeVisitor() {
        public void head(Node node, int depth) {
	    
	    // System.out.println(node.toString() );
	    if(node.nodeName() == "#text") {
		System.out.println(node.toString());
		System.out.println("Depth : " + depth);
	    }
        }

        public void tail(Node node, int depth) {
	    //   System.out.println(node.nodeName());
        }
	});
    }
	


    
}
