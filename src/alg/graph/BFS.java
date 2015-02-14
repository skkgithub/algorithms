package alg.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import ds.graph.IEdge;
import ds.graph.IGraph;
import ds.graph.Vertex;

/**
 * BreadthFirstSearch graph traversing algorithm.
 * 
 * @author saikiran
 */
public class BFS {

	private IGraph g;
	private Map<Vertex,Boolean> explored;
	
	public BFS(IGraph g){
		this.g=g;
		explored=new HashMap<>();
	}
	
	/**
	 * Traverse through the graph from vertex s via breadth first search.
	 */
	public void bfs(Vertex s){
		if(s==null)
			return;
		
		Queue<Vertex> q=new LinkedList<>();
		q.add(s);
		while(!q.isEmpty()){
			Vertex v=q.poll();
			if(explored.get(v)!=null && explored.get(v))
				continue;
			explored.put(v, true);
			System.out.println("explored >> "+v.getId());
			for(IEdge e:g.getAdjEdgesFrom(v)){
				q.add(e.getOther(v));
			}
		}
	}
	
	/**
	 * Returns shortest path from vertex s to vertex v, -1 if there is no path.
	 */
	public int getShortestPath(Vertex s,Vertex v){
		explored=new HashMap<>();
		if(s==null || v==null)
			return -1;
		Map<Vertex,Integer> distance=new HashMap<>();
		
		Queue<Vertex> q=new LinkedList<>();
		q.add(s);
		distance.put(s, 0);
		while(!q.isEmpty()){
			Vertex x=q.poll();
			if(v.equals(x))
				return distance.get(v);
			if(explored.get(x)!=null && explored.get(x))
				continue;
			explored.put(x, true);
			for(IEdge e:g.getAdjEdgesFrom(x)){
				if(explored.get(e.getOther(x))==null || !explored.get(e.getOther(x))){
					q.add(e.getOther(x));
					distance.put(e.getOther(x), distance.get(x)+1);
				}
			}
		}
		return -1;
	}
	
	public boolean isConnected(){
		explored=new HashMap<>();
		bfs(g.getVertices().iterator().next());
		for(Vertex v:g.getVertices()){
			if(explored.get(v)==null || !explored.get(v))
				return false;
		}
		return true;
	}
	
	public boolean isConnected(Vertex v,Vertex w){
		explored=new HashMap<>();
		return getShortestPath(v,w)>=0;
	}
}