package ds.tree;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Node {

	private int key;
	private Node left;
	private Node right;
	private Node parent;
	
	private int size;
	
	public Node(int key,int size){
		this.key=key;this.size=size;
	}

	@Override
	public String toString() {
		return "Node [key=" + key + ", size=" + size + "]";
	}

	
	
}
