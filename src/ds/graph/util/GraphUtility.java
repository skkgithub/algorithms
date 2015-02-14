package ds.graph.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import ds.graph.Edge;
import ds.graph.Graph;
import ds.graph.Graph2;
import ds.graph.IEdge;
import ds.graph.IGraph;
import ds.graph.Vertex;
import ds.graph.WeightedEdge;

/**
 * Utility class for generating/constructing Graphs.
 * @author saikiran
 *
 */
public class GraphUtility {

	public static IGraph loadGraph(Scanner scanner,boolean isWeighted,boolean isDirected){
		IGraph g=new Graph(isDirected,isWeighted);
		int n=scanner.nextInt();
		int m=scanner.nextInt();
		for(int i=0;i<n;i++){
			g.addVertex(new Vertex(i));
		}
		
		for(int i=0;i<m;i++){
			Vertex v=new Vertex(scanner.nextInt());
			Vertex w=new Vertex(scanner.nextInt());
			if(isWeighted){
				g.addEdge(v, w, scanner.nextDouble());
			}else{
				g.addEdge(v, w);
			}
		}
		return g;
	}
	public static Graph2 getGraph(Scanner scanner,boolean isWeighted,boolean isDirected){
		int n=scanner.nextInt();
		int m=scanner.nextInt();
		
		Vertex[] vertices=new Vertex[n];
		for(int i=0;i<n;i++){
			vertices[i]=(new Vertex(i));
		}
		
		List<IEdge> edges=new ArrayList<>();
		Map<Vertex,LinkedList<IEdge>> adjList=new HashMap<>();
		for(int i=0;i<m;i++){
			Vertex v=new Vertex(scanner.nextInt());
			Vertex w=new Vertex(scanner.nextInt());
			IEdge e=isWeighted?new WeightedEdge(v, w, scanner.nextDouble()):new Edge(v, w);
			edges.add(e);
			if(!adjList.containsKey(v)) adjList.put(v, new LinkedList<>());
			if(!adjList.containsKey(w)) adjList.put(w, new LinkedList<>());
			adjList.get(v).add(e);
			if(!isDirected){
				adjList.get(w).add(e);
			}
		}
		return new Graph2(n, m, isDirected, vertices, edges, adjList);
	}
	
	public static IGraph getSimpleDCG(){
		Vertex v1=new Vertex(0);
		Vertex v2=new Vertex(2);
		Vertex v3=new Vertex(3);
		Vertex v4=new Vertex(4);
		Vertex v5=new Vertex(5);
		IGraph g=new Graph(true, false);
		g.addVertex(v1);g.addVertex(v2);g.addVertex(v3);g.addVertex(v4);g.addVertex(v5);
		g.addEdge(v1, v2);
		g.addEdge(v2, v3);
		g.addEdge(v3, v4);
		g.addEdge(v4, v5);
		g.addEdge(v5, v3);
		return g;
	}

	public static Graph2 getSimpleUDCG() {
		Vertex v1=new Vertex(0);
		Vertex v2=new Vertex(2);
		Vertex v3=new Vertex(3);
		Vertex v4=new Vertex(4);
		Vertex v5=new Vertex(5);
		Vertex[] vertices={v1,v2,v3,v4,v5};
		Graph2 g=new Graph2(5, 5, false, vertices, new ArrayList<>(), new HashMap<>());
		g.addEdge(v1, v2);
		g.addEdge(v2, v3);
		g.addEdge(v3, v4);
		g.addEdge(v4, v5);
		g.addEdge(v5, v3);
		return g;
	}
	
	public static IGraph getSampleSCCGraph(){
		IGraph g=new Graph(true, false);
		Vertex[] vertices=new Vertex[9];
		for(int i=1;i<10;i++){
			vertices[i-1]=new Vertex(i);
			g.addVertex(vertices[i-1]);
		}
		g.addEdge(vertices[1-1], vertices[4-1]);
		g.addEdge(vertices[4-1], vertices[7-1]);
		g.addEdge(vertices[7-1], vertices[1-1]);
		g.addEdge(vertices[9-1], vertices[7-1]);
		g.addEdge(vertices[6-1], vertices[9-1]);
		g.addEdge(vertices[9-1], vertices[3-1]);
		g.addEdge(vertices[3-1], vertices[6-1]);
		g.addEdge(vertices[8-1], vertices[6-1]);
		g.addEdge(vertices[2-1], vertices[8-1]);
		g.addEdge(vertices[5-1], vertices[2-1]);
		g.addEdge(vertices[8-1], vertices[5-1]);
		return g;
	}
	
	public static Graph2 reverseGraph(Graph2 g){
		Graph2 grev = new Graph2(g.getVertices().length, g.getEdges().size(), true, g.getVertices(), new ArrayList<>(), new HashMap<>());
		for(IEdge e:g.getEdges()){
			grev.addEdge(e.getOther(e.getOne()), e.getOne());
		}
		return grev;
	}
	
	public static IGraph getReverseGraph(IGraph g){
		Graph grev=new Graph(g.isDirected(), g.isWeighted());
		for(Vertex v:g.getVertices()){
			grev.addVertex(v);
		}
		for(IEdge e:g.getEdges()){
			grev.addEdge(e.getOther(e.getOne()), e.getOne());
		}
		return grev;
	}
}
