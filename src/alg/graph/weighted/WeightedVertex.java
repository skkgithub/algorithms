package alg.graph.weighted;

import lombok.Getter;

@Getter
public class WeightedVertex implements Comparable<WeightedVertex>{
	private int id;
	private double weightedkey;
	private int edgeTo;

	public WeightedVertex(int id,double weightedkey){
		this.id=id;this.weightedkey=weightedkey;
	}
	public WeightedVertex(int id, double weightedkey, int edgeTo) {
		this.id = id;
		this.weightedkey = weightedkey;
		this.edgeTo = edgeTo;
	}
	
	@Override
	public int compareTo(WeightedVertex o) {
		if(weightedkey<o.weightedkey)
			return -1;
		else if(weightedkey>o.weightedkey)
			return 1;
		return 0;
	}

	@Override
	public String toString() {
		return "WeightedVertex [id=" + id + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		WeightedVertex other = (WeightedVertex) obj;
		if (id != other.id)
			return false;
		return true;
	}
}