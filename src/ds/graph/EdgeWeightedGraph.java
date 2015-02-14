package ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import lombok.Getter;

@Getter
public class EdgeWeightedGraph {

	
	private int n;
	private int m;
	private Vertex[] vertices;
	private List<IEdge> edges;
	private Map<Vertex,LinkedList<IEdge>> adjList;
	private Map<Vertex,LinkedList<IEdge>> revAdjList;
	
	private boolean isDirected;
	
	public EdgeWeightedGraph(int n, int m,boolean isDirected) {
		this.n = n;
		this.m = m;
		this.isDirected=isDirected;
		this.revAdjList=new HashMap<>();
	}

	public EdgeWeightedGraph(int n, int m,boolean isDirected, Vertex[] vertices, List<IEdge> edges,
			Map<Vertex, LinkedList<IEdge>> adjList) {
		this.n = n;
		this.m = m;
		this.vertices = vertices;
		this.edges = edges;
		this.adjList = adjList;
		this.isDirected=isDirected;
		this.revAdjList=new HashMap<>();
	}
	
	public void addEdge(Vertex v,Vertex w,double weight){
		if(adjList==null){
			adjList=new HashMap<>();
		}
		IEdge e = new WeightedEdge(v,w,weight);
		edges.add(e);
		if(adjList.get(v)==null)	adjList.put(v, new LinkedList<>());
		if(adjList.get(w)==null)	adjList.put(w, new LinkedList<>());
		adjList.get(v).add(e);
		if(!isDirected){
			adjList.get(w).add(e);
		}
		
		if(revAdjList.get(w)==null) revAdjList.put(w, new LinkedList<>());
		revAdjList.get(w).add(e);
	}
	
	public String toString() {
        String NEWLINE = System.getProperty("line.separator");
        StringBuilder s = new StringBuilder();
        s.append(n + " " + m + NEWLINE);
        for(IEdge e:edges){
        	s.append(e.getOne().getId()+"-"+e.getOther(e.getOne()).getId()+"  ");
        }
        s.append(NEWLINE);
        for(int i=0;i<vertices.length;i++){
        	Vertex v=vertices[i];
        	if(v==null)
        		continue;
        	s.append(v.getId() + ": ");
            for (IEdge e : adjList.get(v)) {
                s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
	
	public static EdgeWeightedGraph getGraph(Scanner scanner,boolean isDirected){
		int n=scanner.nextInt();
		int m=scanner.nextInt();
		
		Vertex[] vertices=new Vertex[n];
		for(int i=0;i<n;i++){
			vertices[i]=new Vertex(i);
		}
		List<IEdge> edges=new ArrayList<>();
		EdgeWeightedGraph g=new EdgeWeightedGraph(n, m, isDirected, vertices, edges, new HashMap<>());
		for(int i=0;i<m;i++){
			Vertex v=new Vertex(scanner.nextInt());
			Vertex w=new Vertex(scanner.nextInt());
			double weight=scanner.nextDouble();
			g.addEdge(v, w, weight);
		}
		return g;
	}
}
