package alg.graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import lombok.Getter;
import ds.graph.IEdge;
import ds.graph.IGraph;
import ds.graph.Vertex;
import ds.graph.util.GraphUtility;

/**
 * Depth First Search graph traversing algorithm.
 * 
 * @author saikiran
 */
@Getter
public class DFS {

	private IGraph g;
	private Map<Vertex,Boolean> explored;
	private Map<Vertex,Integer> dtime;
	private Map<Vertex,Integer> ftime;
	private int time;
	
	public DFS(IGraph g){
		this.g=g;
		reset();
	}
	
	/**
	 * Traverse through the graph from vertex s via depth first search.
	 */
	public void dfs(Vertex s){
		if(explored.get(s)!=null && explored.get(s))
			return;
		time++;
		dtime.put(s, time);
		explored.put(s, true);
		for(IEdge e:g.getAdjEdgesFrom(s)){
			dfs(e.getOther(s));
		}
		ftime.put(s, time);
	}
	
	/**
	 * Returns whether the graph is cyclic or not.
	 */
	public boolean isCyclic(){
		reset();
		
		for(Vertex v:g.getVertices()){
			try {
				dfsCyclic(v);
			} catch (Exception e) {
				if(e.getMessage().equals("CYCLIC"))
					return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Computes Strongly Connected Components using two-pass(kosaraju) algorithm in
	 * a directed graph.
	 */
	public List<String> findSCCs(){
		IGraph grev=GraphUtility.getReverseGraph(g);
		DFS dfs=new DFS(grev);
		Queue<Vertex> to=dfs.getTopologicalOrder();
		grev=null;dfs=null;
		
		Deque<Vertex> cq=new LinkedList<>();
		reset();
		
		List<String> cycles=new ArrayList<>();
		for(Vertex v:to){
			dfsTopologicalOrder(v, cq);
			if(!cq.isEmpty())
				cycles.add(""+cq);
			cq.clear();
		}
		return cycles;
	}
	
	/**
	 * Computes Strongly Connected Components using two-pass(kosaraju) algorithm in
	 * a directed graph, given topological order of the reverse graph.
	 */
	public PriorityQueue<Integer> findSCCs(Queue<Vertex> to){
		Deque<Vertex> cq=new LinkedList<>();
		reset();
		PriorityQueue<Integer> cyclepq=new PriorityQueue<>();
		for(Vertex v:to){
			dfsTopologicalOrder(v, cq);
			if(!cq.isEmpty()){
				if(cyclepq.size()<5){
					cyclepq.offer(cq.size());
				}else if(cyclepq.peek()<cq.size()){
					cyclepq.poll();
					cyclepq.offer(cq.size());
				}
			}
			cq.clear();
		}
		return cyclepq;
	}
	
	/**
	 * Compute topological order of a directed acyclic graph using dfs.
	 */
	public Queue<Vertex> getTopologicalOrder(){
		Deque<Vertex> q=new LinkedList<>();
		for(Vertex v:g.getVertices()){
			dfsTopologicalOrder(v, q);
		}
		return q;
	}
	
	private void dfsTopologicalOrder(Vertex s,Deque<Vertex> q){
		if(explored.get(s)!=null && explored.get(s)){
			return;
		}
		explored.put(s, true);
		for(IEdge e:g.getAdjEdgesFrom(s)){
			dfsTopologicalOrder(e.getOther(s), q);
		}
		q.offerFirst(s);
	}
	
	private void dfsCyclic(Vertex s) throws Exception{
		if(explored.get(s)!=null && explored.get(s))
			return;
		time++;
		dtime.put(s, time);
		explored.put(s, true);
		for(IEdge e:g.getAdjEdgesFrom(s)){
			Vertex w=e.getOther(s);
			if(getDiscoveredTime(w)>0 && getDiscoveredTime(s)>0
					&& getDiscoveredTime(w)<=getDiscoveredTime(s) 
					&& getFinishedTime(w)==-1 && getFinishedTime(s)==-1){
				throw new Exception("CYCLIC");
			}
			dfsCyclic(w);
		}
		time++;
		ftime.put(s, time);
	}
	
	private int getDiscoveredTime(Vertex v){
		if(dtime.get(v)==null)
			return -1;
		return dtime.get(v);
	}
	private int getFinishedTime(Vertex v){
		if(ftime.get(v)==null)
			return -1;
		return ftime.get(v);
	}
	private void reset(){
		explored=new HashMap<>();
		dtime=new HashMap<>();
		ftime=new HashMap<>();
		time=0;
	}
}
