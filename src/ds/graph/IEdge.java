package ds.graph;

public interface IEdge {

	public Vertex getOne();
	public Vertex getOther(Vertex v);
	boolean isWeighted();
	double getWeight();
	//boolean isDirected();
}
