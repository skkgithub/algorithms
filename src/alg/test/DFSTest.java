package alg.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import alg.graph.DFS;
import ds.graph.Graph;
import ds.graph.IEdge;
import ds.graph.IGraph;
import ds.graph.Vertex;
import ds.graph.util.GraphUtility;

public class DFSTest {

	public static void main(String[] args) throws FileNotFoundException{
	    //Scanner scanner = new Scanner(new File("C:\\Users\\saikiran\\Desktop\\testdata\\tinyG.txt"), "UTF-8");
		//Scanner scanner = new Scanner(new File("C:\\Users\\saikiran\\Desktop\\testdata\\tinyDAG.txt"), "UTF-8");
        //scanner.useLocale(Locale.US);
		//Graph g=GraphUtility.getGraph(scanner, false, true);
		//Graph2 g=GraphUtility.getSampleSCCGraph();
        //System.out.println(g);
		
		//DFS2 dfs=new DFS2(g);
		//dfs.krscc();
		//System.out.println(dfs.isConnected());
		//System.out.println(dfs.isDGCyclic(g.getVertices()[0]));
		//System.out.println(dfs.isUDGCyclic(g.getVertices()[0]));
		//dfs.topologicalOrder(g.getVertices()[0]);
		//dfs.topologicalOrder();
		
		//testDFSTraverse();
		//testDFSCyclic();
		//testDFSTopOrder();
		//testSCCs();
		testcourseps4();
	}
	public static void testcourseps4() throws FileNotFoundException{
		System.out.println(new Date());
		Scanner scanner = new Scanner(new File("C:\\Users\\saikiran\\Desktop\\testdata\\SCC.txt"), "UTF-8");
		IGraph grev=new Graph(true,false);
		
		for(int i=1;i<=875714;i++){
			grev.addVertex(new Vertex(i));
		}
		while(scanner.hasNextInt()){
			Vertex v=new Vertex(scanner.nextInt());
			Vertex w=new Vertex(scanner.nextInt());
			grev.addEdge(w,v);
		}
		scanner.close();
		
		System.out.println(new Date());
		System.out.println(grev.getNVertices());
		System.out.println(grev.getNEdges());
		DFS dfs=new DFS(grev);
		Queue<Vertex> q = dfs.getTopologicalOrder();
		System.out.println(q.peek());
		System.out.println(new Date());
		
		List<IEdge> edges=grev.getEdges();grev=null;dfs=null;
		IGraph g=new Graph(true,false);
		for(int i=1;i<=875714;i++){
			g.addVertex(new Vertex(i));
		}
		for(IEdge e:edges){
			g.addEdge(e.getOther(e.getOne()), e.getOne());
		}
		dfs=new DFS(g);
		System.out.println(dfs.findSCCs(q));
		System.out.println(new Date());
	}
	public static void testSCCs(){
		IGraph g=GraphUtility.getSampleSCCGraph();
		System.out.println(g);
		DFS dfs=new DFS(g);
		System.out.println(dfs.findSCCs());
	}
	
	public static void testDFSTopOrder() throws FileNotFoundException{
		Scanner scanner = new Scanner(new File("C:\\Users\\saikiran\\Desktop\\testdata\\tinyDAG.txt"), "UTF-8");
		IGraph g=GraphUtility.loadGraph(scanner, false, true);
		System.out.println(g);
		DFS dfs=new DFS(g);
		System.out.println(dfs.getTopologicalOrder());
	}
	
	public static void testDFSCyclic() throws FileNotFoundException{
		//Scanner scanner = new Scanner(new File("C:\\Users\\saikiran\\Desktop\\testdata\\tinyDG.txt"), "UTF-8");
		//IGraph g=GraphUtility.loadGraph(scanner, false, true);
		IGraph g=GraphUtility.getSimpleDCG();
		System.out.println(g);
		DFS dfs=new DFS(g);
		System.out.println(dfs.isCyclic());
		
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
		pq.add(500);
		pq.add(200);
		pq.add(222);
		pq.add(210);
		if(pq.peek()<215){
			pq.poll();
			pq.add(215);
		}
		System.out.println(pq);
	}
	
	public static void testDFSTraverse() throws FileNotFoundException{
		Scanner scanner = new Scanner(new File("C:\\Users\\saikiran\\Desktop\\testdata\\tinyG.txt"), "UTF-8");
		IGraph g=GraphUtility.loadGraph(scanner, false, false);
		System.out.println(g);
		DFS dfs=new DFS(g);
		dfs.dfs(new Vertex(0));
	}
}
