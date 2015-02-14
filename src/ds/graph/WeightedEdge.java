package ds.graph;

import lombok.Getter;

public class WeightedEdge implements IEdge,Comparable<WeightedEdge>{

	private final Vertex v;
	private final Vertex w;
	@Getter
	private final double weight;
	
	public WeightedEdge(Vertex v, Vertex w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
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
        return String.format("%d-%d %.5f", v.getId(), w.getId(), weight);
    }
	
	@Override
	public int compareTo(WeightedEdge o) {
		if      (this.weight < o.weight) return -1;
        else if (this.weight > o.weight) return +1;
        else    return  0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((v == null) ? 0 : v.hashCode());
		result = prime * result + ((w == null) ? 0 : w.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		WeightedEdge other = (WeightedEdge) obj;
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
		if (Double.doubleToLongBits(weight) != Double
				.doubleToLongBits(other.weight))
			return false;
		if((v.equals(other.v) && w.equals(other.w)) || 
				(v.equals(other.w) && w.equals(other.v)))
			return true;
		else
			return false;
	}
	
	@Override
	public boolean isWeighted() {
		return true;
	}
}
