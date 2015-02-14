package ds.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import lombok.Getter;

/**
 * Graph data structure with Adjacency lists representation.
 * with n vertices & m edges.
 * 
 * @author saikiran
 */
@Getter
public class Graph2 {

	private int n;
	private int m;
	private Vertex[] vertices;
	private List<IEdge> edges;
	private Map<Vertex,LinkedList<IEdge>> adjList;
	
	private boolean isDirected;
	
	public Graph2(int n, int m,boolean isDirected) {
		this.n = n;
		this.m = m;
		this.isDirected=isDirected;
	}

	public Graph2(int n, int m,boolean isDirected, Vertex[] vertices, List<IEdge> edges,
			Map<Vertex, LinkedList<IEdge>> adjList) {
		this.n = n;
		this.m = m;
		this.vertices = vertices;
		this.edges = edges;
		this.adjList = adjList;
		this.isDirected=isDirected;
	}
	
	public void addEdge(Vertex v,Vertex w){
		if(adjList==null){
			adjList=new HashMap<>();
		}
		Edge e = new Edge(v,w);
		edges.add(e);
		if(adjList.get(v)==null)	adjList.put(v, new LinkedList<>());
		if(adjList.get(w)==null)	adjList.put(w, new LinkedList<>());
		adjList.get(v).add(e);
		if(!isDirected){
			adjList.get(w).add(e);
		}
		
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
}
