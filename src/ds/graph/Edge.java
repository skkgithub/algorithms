package ds.graph;


/**
 * Represents an Edge in an unweighted Graph from Vertex v
 * to Vertex w.
 * 
 * @author saikiran
 */
public class Edge implements IEdge{

	private final Vertex v;
	private final Vertex w;
	
	public Edge(Vertex v, Vertex w) {
		this.v = v;
		this.w = w;
	}
	
	public Vertex getOne(){
		return v;
	}
	public Vertex getOther(Vertex x){
		if(x.getId()==v.getId()){
			return w;
		}else if(x.getId()==w.getId()){
			return v;
		}else{
			return null;
		}
	}
	
	public String toString() {
        return String.format("%d-%d", v.getId(), w.getId());
    }
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((v == null) ? 0 : v.hashCode());
		result = prime * result + ((w == null) ? 0 : w.hashCode());
		result = prime * result;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		/*if (v == null) {
			if (other.v != null)
				return false;
		} else if (!v.equals(other.v))
			return false;
		if (w == null) {
			if (other.w != null)
				return false;
		} else if (!w.equals(other.w))
			return false;*/
		if((v.equals(other.v) && w.equals(other.w)) || 
				(v.equals(other.w) && w.equals(other.v)))
			return true;
		else
			return false;
	}

	@Override
	public boolean isWeighted() {
		return false;
	}

	@Override
	public double getWeight() {
		return 0;
	}
}