import java.util.Map;
import java.util.Set;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Map.Entry;
import java.util.*;
import com.google.common.base.MoreObjects;

/*
public class Renderer
{
    // private Table<String, String, Integer> render = HashBasedTable.create();
    private Map<Integer, RenderObject> map=new HashMap<Integer, RenderObject>();
    private static Renderer instance = null;
    int i =0;
    //RenderNode rn;

    protected Renderer() {
	//render = HashBasedTable.create();
    }

    public static Renderer getInstance() {
      if (instance == null) {
         instance = new Renderer();
      }
      return instance;
    }

    public void buildRenderTree(String class_name, String nodeName,String stnode,String attr,String parent, Integer size, Integer depth) {
	map.put(i, new RenderObject(class_name, nodeName, stnode, attr, parent, size, depth));
	i++;
    }

    
    public void print() {
	for(Map.Entry<Integer, RenderObject> entry:map.entrySet()){    
	    int key=entry.getKey();  
	    RenderObject b=entry.getValue();  
	    System.out.println(key+" Details:");  
	    System.out.println(b.nodeName+" "+b.className+" " + b.stnode + " " +b.size+" "+b.depth);   
	}    
    }

    public Map<Integer, RenderObject> getData(){
	return map;
    }
    
}

class RenderObject {

    String nodeName;
    String className;
    String stnode;
    String attr;
    String parent;
    int size;
    int depth;

    RenderObject(String class_name, String nodeName, String stnode,String attr, String parent, Integer size, Integer depth) {
	this.className = class_name;
	this.nodeName = nodeName;
	this.stnode = stnode;
	this.attr = attr;
	this.parent = parent;
	this.size = size;
	this.depth = depth;
    }
}
*/
