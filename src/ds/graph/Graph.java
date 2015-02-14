package ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Implementation class for graph data structure.
 * 
 * @author saikiran
 */
public class Graph implements IGraph {

	private Set<Vertex> vertices;
	private List<IEdge> edges;
	private Map<Vertex,LinkedList<IEdge>> adjList;
	private Map<Vertex,LinkedList<IEdge>> revAdjList;
	private boolean isDirected;
	private boolean isWeighted;
	
	public Graph(boolean isDirected,boolean isWeighted){
		this.isDirected=isDirected;this.isWeighted=isWeighted;
		adjList=new HashMap<>();revAdjList=new HashMap<>();
		vertices=new HashSet<>();edges=new ArrayList<>();
	}
	
	@Override
	public Set<Vertex> getVertices() {
		return vertices;
	}

	@Override
	public List<IEdge> getEdges() {
		return edges;
	}

	@Override
	public int getNVertices() {
		if(vertices==null)
			return 0;
		return vertices.size();
	}

	@Override
	public int getNEdges() {
		if(edges==null)
			return 0;
		return edges.size();
	}

	@Override
	public boolean isDirected() {
		return isDirected;
	}

	@Override
	public boolean isWeighted() {
		return isWeighted;
	}

	@Override
	public List<IEdge> getAdjEdgesFrom(Vertex v) {
		if(adjList==null)
			return null;
		return adjList.get(v);
	}

	@Override
	public List<IEdge> edgesIncidentTo(Vertex v) {
		if(revAdjList==null)
			return null;
		return revAdjList.get(v);
	}


	@Override
	public void addEdge(Vertex v, Vertex w, double weight) {
		if(!isWeighted)
			return;
		WeightedEdge e=new WeightedEdge(v, w, weight);
		edges.add(e);
		
		if(adjList.get(v)==null)	adjList.put(v, new LinkedList<>());
		if(adjList.get(w)==null)	adjList.put(w, new LinkedList<>());
		adjList.get(v).add(e);
		if(!isDirected){
			adjList.get(w).add(e);
		}
		
		//if(revAdjList.get(w)==null) revAdjList.put(w, new LinkedList<>());
		//revAdjList.get(w).add(e);
	}
	
	@Override
	public void addEdge(Vertex v, Vertex w) {
		Edge e=new Edge(v, w);
		edges.add(e);
		
		if(adjList.get(v)==null)	adjList.put(v, new LinkedList<>());
		if(adjList.get(w)==null)	adjList.put(w, new LinkedList<>());
		adjList.get(v).add(e);
		if(!isDirected){
			adjList.get(w).add(e);
		}
	}

	@Override
	public void addVertex(Vertex v) {
		if(vertices==null){
			vertices=new HashSet<>();
		}
		vertices.add(v);
	}
	
	public String toString() {
        String NEWLINE = System.getProperty("line.separator");
        StringBuilder s = new StringBuilder();
        s.append(vertices.size() + " " + edges.size() + NEWLINE);
        for(IEdge e:edges){
        	s.append(e.getOne().getId()+"-"+e.getOther(e.getOne()).getId()+"  ");
        }
        s.append(NEWLINE);
        
        for(Vertex v:vertices){
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