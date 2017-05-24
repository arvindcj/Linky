import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jsoup.select.*;
import org.jsoup.nodes.*;

import java.lang.*;
import java.lang.reflect.*;


import java.io.IOException;

import com.google.common.base.MoreObjects;

class SoupParser
    extends Model {

    String url;
    FetchHTTP fetchData;
    String responseHTML;
    Document document;
    // Renderer render01;
    RenderStyle ren;
    
    public void parseHTML(String url) {
	//	render01 = Renderer.getInstance();
	try {
	    url = "http://127.0.0.1:8080/testdata03.html";
	    Linky.logger.info("*** Input URL ***");
	    Linky.logger.info(url);
	    fetchData = new FetchHTTP();
	    responseHTML = fetchData.fetchHTML(url);
	    Linky.logger.info(responseHTML);
	} catch (Exception e) {}
	document = Jsoup.parse(responseHTML);

	
	document.traverse(new NodeVisitor() {
		
		public void head(Node node, int depth) {
		    /*
		    System.out.println("" + ":" +
				       depth + ":" +
				       MoreObjects.toStringHelper(node).toString() + ":" +
				       node.nodeName() + ":" +
				       node.childNodeSize() + ":" +
				       node + ":" +
				       node.parent() + ":" +
				       node.siblingIndex() + ":" +
				       node.getClass() + ":" + "");
		    */
		    ren = new RenderStyle(node);

		    RenderObject ro = new RenderObject().createObject(node,ren);
		    System.out.println(ro.getClass().toString());
		    /*
		    Linky.logger.info(node.getClass().toString() + " " +
				      // node.hasText() + " " +
				      node.toString() + " " +
				      node.childNodeSize() + " " +
				      "Node name : " + node.nodeName().toString() + " " +
				      depth + 
				      "\n"
				      );
		    */
		}
		
		public void tail(Node node, int depth) {
		    //System.out.println(node.nodeName().toString());
		}
	    });
	//render01.print();
	setChanged();
	notifyObservers();
    }
}
