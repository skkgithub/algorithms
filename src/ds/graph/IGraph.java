package ds.graph;

import java.util.List;
import java.util.Set;

/**
 * Interface for Graph data structure and its operations in 
 * adjacency list representation.
 * 
 * @author saikiran
 */
public interface IGraph {

	Set<Vertex> getVertices();
	List<IEdge> getEdges();
	
	int getNVertices();
	int getNEdges();
	
	boolean isDirected();
	boolean isWeighted();
	
	List<IEdge> edgesIncidentTo(Vertex v);
	List<IEdge> getAdjEdgesFrom(Vertex v);
	
	void addEdge(Vertex v,Vertex w,double weight);
	void addEdge(Vertex v,Vertex w);
	void addVertex(Vertex v);
}
