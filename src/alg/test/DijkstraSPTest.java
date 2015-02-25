package alg.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import alg.graph.weighted.DijkstraSP;
import ds.graph.Graph;
import ds.graph.IGraph;
import ds.graph.Vertex;
import ds.graph.util.GraphUtility;

public class DijkstraSPTest {

	public static void main(String[] args) throws IOException {
		//simpletest();
		testps5();
	}

	
	public static void testps5() throws IOException{
		System.out.println(new Date());
		IGraph g=new Graph(false,true);
		for(int i=1;i<=200;i++){
			g.addVertex(new Vertex(i));
		}
		
		BufferedReader br=new BufferedReader(new FileReader(new File("/Users/skk/Desktop/coursera/testdata/dijkstraData.txt")));
		String line;
		while((line=br.readLine())!=null){
			line=line.trim();
			String[] sline=line.split("\\t");
			Vertex v=new Vertex(Integer.parseInt(sline[0]));
			for(int i=1;i<sline.length;i++){
				String[] ww=sline[i].split(",");
				g.addEdge(v, new Vertex(Integer.parseInt(ww[0])), Double.parseDouble(ww[1]));
			}
		}
		System.out.println(new Date());
		System.out.println(g.getNVertices());
		System.out.println(g.getNEdges());
		
		DijkstraSP dsp=new DijkstraSP(g);
		Map<Vertex,Double> dist=dsp.singleSourceSP(new Vertex(1));
		int[] a={7,37,59,82,99,115,133,165,188,197};
		for(int i=0;i<a.length;i++){
			System.out.println(dist.get(new Vertex(a[i])));
		}
	}
	
	public static void simpletest() throws FileNotFoundException{
		Scanner scanner = new Scanner(new File("/Users/skk/Desktop/coursera/testdata/mediumEWD.txt"), "UTF-8");
        scanner.useLocale(Locale.US);
        IGraph g=GraphUtility.loadGraph(scanner, true, true);
		//System.out.println(g);
		
		DijkstraSP dsp=new DijkstraSP(g);
		
		//System.out.println(dsp.shortestPath(new Vertex(0), new Vertex(1)));
		System.out.println(dsp.shortestPathDistance(new Vertex(0), new Vertex(6)));
		dsp=new DijkstraSP(g);
		Map<Vertex,Double> dist=dsp.singleSourceSP(new Vertex(0));
		System.out.println(dist.get(new Vertex(6)));
	}
}
