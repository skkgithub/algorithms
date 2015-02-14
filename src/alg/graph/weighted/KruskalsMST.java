package alg.graph.weighted;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import ds.graph.Graph2;
import ds.graph.IEdge;
import ds.graph.UF;
import ds.graph.Vertex;

/**
 * Kruskal's algorithm to find MST in a weighted graph with Union Find Data structure.
 * Assumption Graph g is connected
 * 
 * @author saikiran
 */
public class KruskalsMST {

	private Graph2 g;
	private UF uf;
	private List<IEdge> mst;
	private double mstcost;
	
	public KruskalsMST(Graph2 g){
		this.g=g;
		reset();
	}
	
	public double findMST(){
		PriorityQueue<IEdge> pq=new PriorityQueue<>();
		for(IEdge e:g.getEdges()){
			pq.add(e);
		}
		while(!pq.isEmpty()){
			IEdge e=pq.poll();
			Vertex v=e.getOne();
			Vertex w=e.getOther(v);
			if(!uf.isConnected(v,w)){
				uf.union(v, w);
				mst.add(e);
				mstcost+=e.getWeight();
			}
		}
		return mstcost;
	}
	
	public void reset(){
		uf=new UF(g.getVertices());
		mst=new ArrayList<>();
		mstcost=0;
	}
	
}