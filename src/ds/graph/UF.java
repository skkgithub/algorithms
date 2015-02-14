package ds.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * Lazy Union Find data structure implementation.
 * 
 * @author saikiran
 */
public class UF {

	private Map<Vertex,Vertex> leaders;
	private Map<Vertex,Integer> size;
	
	public UF(Vertex[] vertices){
		reset(vertices);
	}
	
	public void reset(Vertex[] vertices){
		leaders=new HashMap<>();
		size=new HashMap<>();
		for(Vertex v:vertices){
			leaders.put(v, v);
			size.put(v, 1);
		}
	}
	
	public Vertex find(Vertex v){
		while(!leaders.get(v).equals(v))
			v=leaders.get(v);
		return v;
	}
	
	public boolean isConnected(Vertex v,Vertex w){
		return find(v).equals(find(w));
	}
	
	public void union(Vertex v,Vertex w){
		Vertex vp=find(v);
		Vertex wp=find(w);
		
		int vpsize=size.get(vp);
		int wpsize=size.get(wp);
		
		if(vpsize>wpsize){
			leaders.put(wp, vp);
			size.put(vp, vpsize+wpsize);
		}else{
			leaders.put(vp, wp);
			size.put(wp, vpsize+wpsize);
		}
	}
}