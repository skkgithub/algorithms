/*package alg.random;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

import ds.graph.Edge;
import ds.graph.Graph2;
import ds.graph.Vertex;

public class GraphMinCut {

	private Graph2 g;
	
	public GraphMinCut(Graph2 g){
		this.g=g;
	}
	
	List<Vertex> removedVertices=new ArrayList<Vertex>();
	public List<Edge> mincut(){
		int n=0;
		List<Edge> edges=null;
		
		while(n<(g.getN()-2)){
			edges=g.getEdges();

			int nrandom=getRandomEdge(edges.size()-1);
			Edge e=edges.get(nrandom);
			Vertex v=e.getOne();
			Vertex w=e.getOther(v);
			
			g.getAdjList().get(v).remove(e);
			g.getAdjList().get(w).remove(e);
			
			//new code
			Iterator<Edge> itr=g.getAdjList().get(w).iterator();
			while(itr.hasNext()){
				Edge fe=itr.next();
				Edge newedge=new Edge(v,fe.getOther(w));
				g.getAdjList().get(fe.getOther(w)).remove(fe);
				g.getEdges().remove(fe);
				if(v.getId()==fe.getOther(w).getId())
					continue;
				g.getEdges().add(newedge);
				g.getAdjList().get(v).add(newedge);
				g.getAdjList().get(fe.getOther(w)).add(newedge);
			}
			//end of new code
			
			for(Edge fe:g.getAdjList().get(w)){
				Edge newedge=new Edge(v,fe.getOther(w));
				g.getAdjList().get(v).add(newedge);
				g.getAdjList().get(fe.getOther(w)).add(newedge);
				g.getAdjList().get(fe.getOther(w)).remove(fe);
				g.getEdges().add(newedge);
				g.getEdges().remove(fe);
			}
			g.getAdjList().put(w, new LinkedList<>());
			while(g.getEdges().contains(e)){
				g.getEdges().remove(e);
			}
			//g.getEdges().remove(e);
			n++;
			removedVertices.add(w);
		}
		return edges;
		//System.out.println(g.getAdjList().get(edges.get(0).getOne()));
		//System.out.println(removedVertices);
	}
	
	private int getRandomEdge(int n){
		return new Random().nextInt(n+1);
	}
	
	public static void main(String[] args){
		
		GraphMinCut gmc=null;
		int gmincut=Integer.MAX_VALUE;
		//List<Edge> edges=null;
		Graph2 g=getGraphFromFile();
		
		for(int i=0;i<100000;i++){
			//Graph g=getGraph();
			
			gmc=new GraphMinCut(getClone(g));
			List<Edge> mincutedges=gmc.mincut();
			//System.out.println("mincut from iteration: "+i+" >> "+mincutedges.size());
			if(mincutedges.size()<gmincut){
				gmincut=mincutedges.size();
				//edges=mincutedges;
			}
		}
		System.out.println(gmincut);
		//System.out.println(edges);
		
	}
	
	public static Graph2 getClone(Graph2 g){
		Vertex[] vertices=new Vertex[g.getN()];
		for(int i=0;i<g.getN();i++){
			vertices[i]=new Vertex(g.getVertices()[i].getId());
		}
		List<Edge> edges = new ArrayList<>();
		for(Edge edge:g.getEdges()){
			Edge e=new Edge(new Vertex(edge.getOne().getId()),new Vertex(edge.getOther(edge.getOne()).getId()), 0);
			edges.add(e);
		}
		
		Map<Vertex,LinkedList<Edge>>adjList=new HashMap<>();
		for(Vertex v:g.getAdjList().keySet()){
			adjList.put(new Vertex(v.getId()), new LinkedList<>());
			for(Edge e:g.getAdjList().get(v)){
				adjList.get(v).add(new Edge(new Vertex(e.getOne().getId()),new Vertex(e.getOther(e.getOne()).getId()), 0));
			}
		}
		Graph2 g2=new Graph2(g.getN(), g.getM(), false, vertices, edges, adjList);
		return g2;
	}
	
	public static Graph2 getGraph(){
		Vertex[] vertices=new Vertex[4];
		for(int i=0;i<4;i++){
			vertices[i]=new Vertex(i);
		}
		Graph2 g=new Graph2(4, 5, false, vertices, new ArrayList<>(), new HashMap<>());
		g.addEdge(vertices[0], vertices[1]);
		g.addEdge(vertices[1], vertices[2]);
		g.addEdge(vertices[0], vertices[2]);
		g.addEdge(vertices[2], vertices[3]);
		g.addEdge(vertices[0], vertices[3]);
		//System.out.println(g);
		return g;
	}
	
	public static Graph2 getGraphFromFile(){
		
		String filepath="C:\\Users\\saikiran\\Desktop\\testdata\\kargerMinCut.txt";
		try {
			FileReader fr=new FileReader(filepath);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			int row=1;
			Graph2 g=new Graph2(200, 200, true, new Vertex[200], new LinkedList<Edge>(), new HashMap<>());
			int nedges=0;
			List<Edge> edges=new ArrayList<>();
			while(true){
				line=br.readLine();
				if(line==null || line.isEmpty()){
					break;
				}
				StringTokenizer st = new StringTokenizer(line, "\t");
				g.getVertices()[row-1]=new Vertex(Integer.parseInt(st.nextToken()));
				while(st.hasMoreTokens()){
					nedges++;
					Edge e=new Edge(g.getVertices()[row-1], new Vertex(Integer.parseInt(st.nextToken())));
					g.addEdge(e.getOne(),e.getOther(e.getOne()));
					if(!edges.contains(e))
						edges.add(e);
				}
				row++;
			}
			System.out.println(nedges);
			System.out.println(edges.size());
			//g.setEdges(edges);
			//g.setDirected(false);
			return g;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
*/