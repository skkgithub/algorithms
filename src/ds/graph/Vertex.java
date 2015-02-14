package ds.graph;

import lombok.Getter;
/**
 * Represents a Vertex in a graph.
 * 
 * @author saikiran
 */
public class Vertex {
	
	@Getter
	private final int id;
	
	//@Getter @Setter
	//private String label;
	
	public Vertex(int id) {
		this.id = id;
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
		Vertex other = (Vertex) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vertex [id=" + id + "]";
	}
}
