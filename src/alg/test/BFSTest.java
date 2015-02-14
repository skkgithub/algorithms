package alg.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import alg.graph.BFS;
import ds.graph.IGraph;
import ds.graph.Vertex;
import ds.graph.util.GraphUtility;

public class BFSTest {

	public static void main(String[] args) throws FileNotFoundException{
	    
		testBFSSP();
	}
	
	public static void testBFSSP() throws FileNotFoundException{
		Scanner scanner = new Scanner(new File("C:\\Users\\saikiran\\Desktop\\testdata\\tinyG.txt"), "UTF-8");
		IGraph g=GraphUtility.loadGraph(scanner, false, false);
		System.out.println(g);
		BFS bfs=new BFS(g);
		//bfs.bfs(new Vertex(0));
		//System.out.println(bfs.getShortestPath(new Vertex(8), new Vertex(7)));
		System.out.println(bfs.isConnected(new Vertex(9), new Vertex(7)));
	}
}
