package alg.graph.weighted;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import lombok.Getter;
import ds.graph.Graph2;
import ds.graph.IEdge;
import ds.graph.Vertex;
import ds.graph.WeightedEdge;

/**
 * Finds a Minimum Spanning Tree using Prim's Greedy Algorithm
 * Assumptions : Graph g is connected
 * 
 * @author saikiran
 */
public class PrimsMST {

	private Graph2 g;
	private Map<Vertex,Boolean> X;
	private int Xn;
	private Map<Vertex,Double> weightedkeys;
	@Getter
	private List<IEdge> mst;
	private double mstcost;
	
	public PrimsMST(Graph2 g){
		this.g=g;
		reset();
	}
	
	public void reset(){
		weightedkeys=new HashMap<>();
		X=new HashMap<>();
		mstcost=0;Xn=0;
		mst=new ArrayList<IEdge>();
	}
	
	/**
	 * Finds MST
	 * Data structure PriorityQueue is used for better performance.
	 * Invariants Maintained: Elements of PriorityQueue are vertices of G(V)-X with keys as weight of lease cost edge
	 * crossing from X to G(V)-X
	 */
	public double findMST(){
		PriorityQueue<WeightedVertex> pq=new PriorityQueue<>();
		pq.add(new WeightedVertex(g.getVertices()[0].getId(), 0));
		while(Xn<g.getN() && !pq.isEmpty()){
			WeightedVertex wv=pq.poll();
			Vertex s=new Vertex(wv.getId());
			if(X.get(s)!=null && X.get(s)){
				continue;
			}
			Xn++;X.put(s, true);mstcost+=wv.getWeightedkey();mst.add(new WeightedEdge(s, new Vertex(wv.getEdgeTo()), wv.getWeightedkey()));
			
			for(IEdge e:g.getAdjList().get(s)){
				Vertex w=e.getOther(s);
				if(X.get(w)!=null && X.get(w)){
					continue;
				}
				if(weightedkeys.get(w)==null || weightedkeys.get(w)>e.getWeight()){
					weightedkeys.put(w, e.getWeight());
					
					pq.add(new WeightedVertex(w.getId(), e.getWeight(),s.getId()));
				}
			}
		}
		return mstcost;
	}
}
