import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.select.*;
import org.jsoup.nodes.*;
import java.util.*;
import java.awt.Font;

/* RenderStyle of HTML Nodes
   1. used to style HTML TAGS.
   2. build RenderStyle map. 
*/
class RenderStyle {

    private Node node;
    
    public enum RS {
	NONE,
	INLINE,
	BLOCK,
	LIST_ITEM
    }

    RS r;
    
    Font font = new Font("Arial", Font.PLAIN , 11);

    Map<String, ArrayList<Object>> map = new HashMap<String, ArrayList<Object>>();

    RenderStyle(Node node) {
	map.put("#document",new ArrayList<Object>(Arrays.asList(r.NONE)));
	map.put("html",new ArrayList<Object>(Arrays.asList(r.NONE)));
	map.put("head",new ArrayList<Object>(Arrays.asList(r.NONE)));
	map.put("body",new ArrayList<Object>(Arrays.asList(r.NONE)));
	map.put("#text",new ArrayList<Object>(Arrays.asList(r.INLINE, font)));
	map.put("div",new ArrayList<Object>(Arrays.asList(r.BLOCK)));
	this.node = node;
    }

    public RS display() {

	if(map.containsKey(node.nodeName())) {
	    return (RS) map.get(node.nodeName()).get(0);
	} else {
	    return null;
	}
    }

    public ArrayList<Object> getKey(String key) {
	return map.get(key);
    }

    public boolean containsNode(String key){
	System.out.println( map.containsKey(key));
	return map.containsKey(key) ? true : false;
    }

    public Font getStyles(String key) {
	return (Font) map.get(key).get(1);
    }
}
