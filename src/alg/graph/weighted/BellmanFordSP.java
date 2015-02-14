/*package alg.graph.weighted;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import ds.graph.Edge;
import ds.graph.EdgeWeightedGraph;
import ds.graph.Vertex;

public class BellmanFordSP {

	private EdgeWeightedGraph g;
	
	public BellmanFordSP(EdgeWeightedGraph g){
		this.g=g;
	}
	private Map<Vertex,Vertex> spaths;
	
	public Map<Vertex,Vertex> computeSP(Vertex s){
		spaths=new HashMap<>();
		
		Map<Vertex,Double> pmap=new HashMap<>();
		for(Vertex v:g.getVertices()){
			pmap.put(v, Double.POSITIVE_INFINITY);
		}
		pmap.put(s, new Double(0));
		spaths.put(s, s);
		
		Map<Vertex,Double> lmap=new HashMap<>();
		for(int i=1;i<g.getN();i++){
			for(Vertex v:g.getVertices()){
				double minwt=pmap.get(v);
				
				for(Edge e:g.getRevAdjList().get(v)){
					if(minwt>pmap.get(e.getOther(v))+e.getWeight()){
						spaths.put(v, e.getOther(v));
						minwt=pmap.get(e.getOther(v))+e.getWeight();
					}
				}
				lmap.put(v, minwt);
			}
			pmap=lmap;
			lmap=new HashMap<>();
		}
		// extra iteration for checking negative cycle
		for(Vertex v:g.getVertices()){
			double minwt=pmap.get(v);
			
			for(Edge e:g.getRevAdjList().get(v)){
				if(minwt>pmap.get(e.getOther(v))+e.getWeight()){
					//spaths.put(v, e.getOther(v));
					minwt=pmap.get(e.getOther(v))+e.getWeight();
				}
			}
			lmap.put(v, minwt);
		}
		if(!areIdentical(pmap, lmap)){
			throw new IllegalArgumentException("Graph should not contain a negative cycle");
		}
		return spaths;
	}
	
	private boolean areIdentical(Map<Vertex,Double> pmap,Map<Vertex,Double> lmap){
		for(Vertex v:g.getVertices()){
			if(!pmap.get(v).equals(lmap.get(v)))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		Scanner scanner = new Scanner(new File("C:\\Users\\saikiran\\Desktop\\testdata\\tinyEWDnc.txt"), "UTF-8");
		EdgeWeightedGraph g=EdgeWeightedGraph.getGraph(scanner, true);
		BellmanFordSP bfsp=new BellmanFordSP(g);
		Map<Vertex,Vertex> spaths=bfsp.computeSP(new Vertex(0));
		StringBuilder sb=new StringBuilder();
		Vertex v=new Vertex(5);
		while(!spaths.get(v).equals(v)){
			sb.append(v.getId()+"-");
			v=spaths.get(v);
		}
		sb.append("0");
		System.out.println(sb.reverse().toString());
	}
}*/