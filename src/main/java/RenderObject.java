import java.awt.Rectangle;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.select.*;
import org.jsoup.nodes.*;
import org.jsoup.nodes.TextNode;
import java.awt.Graphics;
import java.util.*;
import java.awt.FontMetrics;
import java.awt.Font;

     enum RS {
	NONE,
	INLINE,
	BLOCK,
	LIST_ITEM
    }

class RenderObject {

    RS rs;

    int x =0;
    int y = 0;

    public void setX(int x) {
	this.x = x;
    }

    public int getX() {
	return this.x;
    }

    
    public void setY(int y) {
	this.y = y;
    }

    public int getY() {
	return this.y;
    }
    
    void layout(){};
    void paintObj(Graphics graphics){};
    void paintRect(){};
    Node node; 
    RenderStyle style;

    public Node getNode(){
	return this.node;
    }

    public RenderStyle getStyle() {
	return this.style;
    }

    //RenderObject(Node node, RenderStyle style){}

    public RenderObject createObject(Node node, RenderStyle style) {
	RenderObject o = null;

	//this.node = node;
	this.style = style;
	System.out.println("Styke styke : " + style);
	switch (style.display()) {
        case NONE:
	    o = new RenderNone(node, style);
            break;
        case INLINE:
            o = new RenderInline(node, style);
            break;
        case BLOCK:
            o = new RenderBlock(node, style);
            break;
        case LIST_ITEM:
            o = new RenderListItem(node, style);
            break;
	}

    return o;
    }

}


class RenderNone extends RenderObject {
    void layout() {}
    void paintObj(Graphics graphics) {}
    void paintRect(Graphics graphics) {}
    RenderNone(Node node, RenderStyle style ) { this.node = node;}
}

class RenderInline extends RenderObject {
    int padding = 10;
    int textWidth;
    int textHeight;
    
    FontMetrics metrics;
    
    void layout() {
	setX(this.textWidth + padding);
	setY(this.textHeight + padding);
    }

    void paintObj(Graphics graphics) {
	paintRect(graphics);
	System.out.println("paint obj : " + this.node.toString());
	graphics.drawString(this.node.toString(), getX(), getY());
	layout();
    }
    
    void paintRect(Graphics graphics) {
	
	System.out.println("get Style : " + getStyle());
	
	if (this.style.containsNode("#text") ) {
	    Font font = (Font) this.style.getStyles("#text");
	    metrics = graphics.getFontMetrics(font);
	    this.textWidth = metrics.stringWidth(this.node.toString());
	    this.textHeight = metrics.getHeight();
	}
	
    }

    RenderInline(Node node, RenderStyle style) {
	this.node = node;
	this.style = style;
	System.out.println(node);
    }
}

class RenderBlock extends RenderObject {
    void layout() {}
    void paintObj(Graphics graphics) {}
    void paintRect() {}
    RenderBlock(Node node, RenderStyle style){}

}

class RenderListItem extends RenderObject {
    void layout() {}
    void paintObj(Graphics graphics) {}
    void paintRect() {}
    RenderListItem(Node nodee, RenderStyle style) {}

}

