package alg.graph.weighted;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import ds.graph.IEdge;
import ds.graph.IGraph;
import ds.graph.Vertex;

/**
 * Disjkstra's Greedy Algorithm for finding single source shortest paths in weighted & directed graphs.
 * Assumes graph has non-negative edge weights.
 * 
 * @author saikiran
 */
public class DijkstraSP {

	private IGraph g;
	
	public DijkstraSP(IGraph g){
		this.g=g;
	}
	
	public double shortestPathDistance(Vertex s, Vertex d){
		Map<Vertex,Double> dist=new HashMap<>();
		PriorityQueue<WeightedVertex> pq=new PriorityQueue<>(); //Min Heap with weighted vertices
		pq.add(new WeightedVertex(s.getId(), 0));
		dist.put(s, new Double(0));
		for(int i=g.getNVertices()-1;i>=1;i--){
			if(pq.isEmpty())
				break;
			WeightedVertex wv=pq.poll();
			Vertex v=new Vertex(wv.getId());
			if(v.equals(d)) // destination reached with shortest path
				break;
			for(IEdge e:g.getAdjEdgesFrom(v)){
				Vertex w=e.getOther(v);
				if(dist.get(w)!=null && dist.get(w)<=dist.get(v)+e.getWeight())
					continue;
				
				if(dist.get(w)!=null && dist.get(w)>dist.get(v)+e.getWeight())
					pq.remove(new WeightedVertex(w.getId(), dist.get(v)+e.getWeight()));
				
				pq.add(new WeightedVertex(w.getId(), dist.get(v)+e.getWeight()));
				dist.put(w, dist.get(v)+e.getWeight());
			}
		}
		return dist.get(d)==null?Double.POSITIVE_INFINITY:dist.get(d);
	}
	
	public Queue<Vertex> shortestPath(Vertex s, Vertex d){
		Map<Vertex,Vertex> path=new HashMap<>();
		Map<Vertex,Double> dist=new HashMap<>();
		PriorityQueue<WeightedVertex> pq=new PriorityQueue<>(); //Min Heap with weighted vertices
		pq.add(new WeightedVertex(s.getId(), 0));
		dist.put(s, new Double(0));
		path.put(s, s);
		for(int i=g.getNVertices()-1;i>=1;i--){
			if(pq.isEmpty())
				break;
			WeightedVertex wv=pq.poll();
			Vertex v=new Vertex(wv.getId());
			if(v.equals(d)) // destination reached with shortest path
				break;
			for(IEdge e:g.getAdjEdgesFrom(v)){
				Vertex w=e.getOther(v);
				if(dist.get(w)!=null && dist.get(w)<=dist.get(v)+e.getWeight())
					continue;
				
				if(dist.get(w)!=null && dist.get(w)>dist.get(v)+e.getWeight())
					pq.remove(new WeightedVertex(w.getId(), dist.get(v)+e.getWeight()));
				
				pq.add(new WeightedVertex(w.getId(), dist.get(v)+e.getWeight()));
				dist.put(w, dist.get(v)+e.getWeight());
				path.put(w, v);
			}
		}
		if(path.get(d)==null)
			return null;
		Queue<Vertex> pathqueue=new LinkedList<>();
		Vertex p=d;
		while(!p.equals(path.get(p))){
			pathqueue.offer(p);
			p=path.get(p);
		}
		pathqueue.offer(s);
		return pathqueue;
	}
	
	public Map<Vertex, Double> singleSourceSP(Vertex s){
		Map<Vertex,Double> dist=new HashMap<>();
		PriorityQueue<WeightedVertex> pq=new PriorityQueue<>(); //Min Heap with weighted vertices
		pq.add(new WeightedVertex(s.getId(), 0));
		dist.put(s, new Double(0));
		for(int i=g.getNVertices()-1;i>=1;i--){
			if(pq.isEmpty())
				break;
			WeightedVertex wv=pq.poll();
			Vertex v=new Vertex(wv.getId());
			for(IEdge e:g.getAdjEdgesFrom(v)){
				Vertex w=e.getOther(v);
				if(dist.get(w)!=null && dist.get(w)<=dist.get(v)+e.getWeight())
					continue;
				
				if(dist.get(w)!=null && dist.get(w)>dist.get(v)+e.getWeight())
					pq.remove(new WeightedVertex(w.getId(), dist.get(v)+e.getWeight()));
				
				pq.add(new WeightedVertex(w.getId(), dist.get(v)+e.getWeight()));
				dist.put(w, dist.get(v)+e.getWeight());
			}
		}
		return dist;
	}
}
