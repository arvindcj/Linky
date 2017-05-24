import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.select.*;
import org.jsoup.nodes.*;
import java.util.*;
import java.awt.Font;

class RenderStyle {

    private Node node;
    
    public enum RS {
	NONE,
	INLINE,
	BLOCK,
	LIST_ITEM
    }

    RS r;
    
    Font font = new Font ("Arial", Font.PLAIN , 11);
    
    List none = new ArrayList();
    List inline = new ArrayList();
    List block = new ArrayList();

    Map<String, ArrayList<Object>> map = new HashMap<String, ArrayList<Object>>();

    RenderStyle(Node node) {
	map.put("#document",new ArrayList(r.NONE));
	none.add("#document");
	none.add("html");
	none.add("head");
	none.add("body");
	inline.add("#text");
	block.add("div");
	this.node = node;
    }

    public RS display(){
	if(none.contains(node.nodeName())) {
	    System.out.println("NONE");
	    return r.NONE;
	} else
	if(inline.contains(node.nodeName())) {
	    System.out.println("INLINE");
	    return r.INLINE;
	} else
	if(block.contains(node.nodeName())) {
	    System.out.println("BLOCK");
	    return r.BLOCK;
	} else {
	    return null;
	}
    }
}
