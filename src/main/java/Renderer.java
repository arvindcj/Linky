import java.util.Map;
import java.util.Set;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Map.Entry;
import java.util.*;
import com.google.common.base.MoreObjects;

/* Renderer Singleton design pattern
   1. Render Tree built from RenderObject. 
   2. Associate Render Style with Render Object.
 */
public class Renderer
{
 
    private Map<Integer, RenderObject> map;
    map=new HashMap<Integer, RenderObject>();
    private static Renderer instance = null;
    int i =0;
    //RenderNode rn;

    protected Renderer() {
    }

    public static Renderer getInstance() {
      if (instance == null) {
         instance = new Renderer();
      }
      return instance;
    }

    public void buildRenderTree(RenderObject ro) {
	map.put(i, ro);
	i++;
    }

    public Map<Integer, RenderObject> getData(){
	return map;
    }
    
}

 
