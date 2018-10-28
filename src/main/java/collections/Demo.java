package collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;



public class Demo {

	public static void main(String...strings){
		Map<String,String> cmap = new ConcurrentHashMap<String,String>(4);
		cmap.put("1", "1");
		cmap.put("2", "2");
		cmap.put("3", "3");
		cmap.put("4", "4");
		cmap.put("5", "5");
		
		System.out.println(" cmap -> "+cmap);
		Iterator<String> itr = cmap.keySet().iterator();
		while(itr.hasNext()){
			String key = itr.next();
			if("3".equals(key))cmap.put(key+"new", "new3");
		}
		System.out.println(" cmap changed -> "+cmap);
		System.out.println(" ============= ");
		Map<String,String> hmap = new HashMap<String,String>();
		
		hmap.put("1", "1");
		hmap.put("3", "2");
		hmap.put("4", "4");
		hmap.put("5", "5");
		
		synchronized (hmap) {
			for(String key:hmap.keySet()){
				if("3".equals(key))hmap.put(key+"new", "new3");
			}
		}
		
		
		
		System.out.println("hmap -> "+hmap);
	}
}
