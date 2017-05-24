import java.awt.Rectangle;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.select.*;
import org.jsoup.nodes.*;
import org.jsoup.nodes.TextNode;

     enum RS {
	NONE,
	INLINE,
	BLOCK,
	LIST_ITEM
    }

class RenderObject {

    RS rs;

    void layout(){};
    void paint(){};
    Rectangle paintRect(){return null;};
    Node node; 
    RenderStyle style;
           
    public RenderObject createObject(Node node, RenderStyle style) {
	RenderObject o = null;
	
	switch (style.display()) {
        case NONE:
	    o = new RenderNone(node);
            break;
        case INLINE:
            o = new RenderInline(node);
            break;
        case BLOCK:
            o = new RenderBlock(node);
            break;
        case LIST_ITEM:
            o = new RenderListItem(node);
            break;
	}

    return o;
    }

}


class RenderNone extends RenderObject {
    void layout() {}
    void paint() {}
    Rectangle paintRect() {return null;}
    RenderNone(Node node) {}
}

class RenderInline extends RenderObject {
    void layout() {}
    void paint() {}
    Rectangle paintRect() {return null;}
    RenderInline(Node node) {
	System.out.println(node);
    }
}

class RenderBlock extends RenderObject {
    void layout() {}
    void paint() {}
    Rectangle paintRect() {return null;}
    RenderBlock(Node node){}

}

class RenderListItem extends RenderObject {
    void layout() {}
    void paint() {}
    Rectangle paintRect() {return null;}
    RenderListItem(Node node) {}

}

