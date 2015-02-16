package alg.graph.weighted;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import lombok.Getter;
import ds.graph.Graph2;
import ds.graph.IEdge;
import ds.graph.Vertex;

/**
 * Dijkstra's algorithm to find shortest path between two vertices in a directed weighted graph
 * with non-negative edges.
 * 
 * @author saikiran
 */
public class DijkstraSP2 {

	private Graph2 g;
	private Map<Vertex,Double> dist;
	private Map<Vertex,Boolean> explored;
	private Map<Vertex,Double> weightedkeys;
	@Getter
	private Map<Vertex,Vertex> vertexDir;
	
	public DijkstraSP2(Graph2 g){
		this.g=g;
		reset();
	}
	public void reset(){
		dist=new HashMap<>();
		weightedkeys=new HashMap<>();
		explored=new HashMap<>();
		vertexDir=new HashMap<>();
	}
	public double findSP(Vertex s,Vertex d){
		reset();
		explored.put(s, true);
		dist.put(s, new Double(0));
		PriorityQueue<WeightedVertex> pq=new PriorityQueue<>();
		pq.add(new WeightedVertex(s.getId(), 0));

		while(true){
			WeightedVertex wk=pq.poll();
			if(wk==null)
				break;
			Vertex v=new Vertex(wk.getId());
			
			explored.put(v, true);
			dist.put(v, wk.getWeightedkey());
			if(wk.getId()==d.getId()){
				return wk.getWeightedkey();
			}
			
			for(IEdge e:g.getAdjList().get(v)){
				Vertex w=e.getOther(v);
				if(explored.get(w)!=null && explored.get(w)){
					continue;
				}
				if(weightedkeys.get(w)==null){
					WeightedVertex wv=new WeightedVertex(w.getId(), dist.get(v)+e.getWeight());
					pq.add(wv);
					weightedkeys.put(w, wv.getWeightedkey());
					vertexDir.put(w, v);
					continue;
				}
				if(weightedkeys.get(w)!=null && weightedkeys.get(w)>dist.get(v)+e.getWeight()){
					WeightedVertex wv=new WeightedVertex(w.getId(), dist.get(v)+e.getWeight());
					pq.remove(wv);
					pq.add(wv);
					vertexDir.put(w, v);
					weightedkeys.put(w, wv.getWeightedkey());
				}
			}
		}
		
		return Double.POSITIVE_INFINITY;
	}
	
	public void test(){
		WeightedVertex wv1=new WeightedVertex(1, 10);
		WeightedVertex wv2=new WeightedVertex(1, 5);
		PriorityQueue<WeightedVertex> pq=new PriorityQueue<>();
		pq.add(wv1);pq.add(wv2);
		
		System.out.println(pq.poll());
		System.out.println(pq.poll());
	}
	
	
}