package alg.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import alg.graph.weighted.DijkstraSP;
import ds.graph.IGraph;
import ds.graph.Vertex;
import ds.graph.util.GraphUtility;

public class DijkstraSPTest {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("/Users/skk/Desktop/coursera/testdata/mediumEWD.txt"), "UTF-8");
        scanner.useLocale(Locale.US);
        System.out.println(new Date());
        IGraph g=GraphUtility.loadGraph(scanner, true, true);
        System.out.println(new Date());
		//System.out.println(g);
		
		DijkstraSP dsp=new DijkstraSP(g);
		
		//DijkstraSP2 dsp=new DijkstraSP2(g);
		System.out.println(dsp.shortestPath(new Vertex(0), new Vertex(1)));
		
		System.out.println(new Date());

	}

}
