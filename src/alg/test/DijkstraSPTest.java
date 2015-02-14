package alg.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import alg.graph.weighted.DijkstraSP;
import ds.graph.Graph2;
import ds.graph.Vertex;
import ds.graph.util.GraphUtility;

public class DijkstraSPTest {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("C:\\Users\\saikiran\\Desktop\\testdata\\tinyEWD.txt"), "UTF-8");
        scanner.useLocale(Locale.US);
		Graph2 g=GraphUtility.getGraph(scanner, true, true);
		System.out.println(g);
		
		DijkstraSP dsp=new DijkstraSP(g);
		System.out.println(dsp.findSP(new Vertex(0), new Vertex(6)));
		
		Map<Vertex,Vertex> vertexdir=dsp.getVertexDir();
		Vertex v=new Vertex(6);
		while(vertexdir.get(v)!=null){
			System.out.print(vertexdir.get(v)+" ");
			v=vertexdir.get(v);
		}
		System.out.println(dsp.findSP(new Vertex(0), new Vertex(10)));
	}

}
