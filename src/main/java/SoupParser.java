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

/* HTML Parser 
   1. uses Soap Library.
   2. get raw HTML from FetchHTTP.
   3. Parse raw HTML.
   4. Traverse parsed HTML.
   5. set RenderStyle.
   6. create RenderObject.
   7. create build Tree.
*/
class SoupParser
    extends Model {

    String url;
    FetchHTTP fetchData;
    String responseHTML;
    Document document;
    Renderer render01;
    RenderStyle ren;
    RenderObject ro;
    
    public void parseHTML(String url) {
	
	try {
	    Linky.logger.info("*** Input URL ***");
	    Linky.logger.info(url);
	    fetchData = new FetchHTTP();
	    responseHTML = fetchData.fetchHTML(url);
	    render01 = Renderer.getInstance();
	    Linky.logger.info(responseHTML);
	} catch (Exception e) {}
	document = Jsoup.parse(responseHTML);
	
	document.traverse(new NodeVisitor() {
		
		public void head(Node node, int depth) {
		    
		    ren = new RenderStyle(node);
		    ro = new RenderObject().createObject(node, ren);
		    
		    render01.buildRenderTree(ro);
		}
		
		public void tail(Node node, int depth) {   
		}
	    });
	
	setChanged();
	notifyObservers();
    }
}
