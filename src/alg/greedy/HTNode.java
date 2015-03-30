package alg.greedy;

import lombok.Getter;
import lombok.Setter;

@Getter
public class HTNode implements Comparable<HTNode>{

	private Character data;
	private Float frequency;
	@Setter
	private HTNode left;
	@Setter
	private HTNode right;
	
	public HTNode(Character data, Float frequency) {
		this.data = data;
		this.frequency = frequency;
	}
	public HTNode(Float frequency) {
		this.frequency = frequency;
	}
	
	@Override
	public int compareTo(HTNode o) {
		return frequency.compareTo(o.getFrequency());
	}
	
	@Override
	public String toString() {
		return "HTNode [data=" + data + ", frequency=" + frequency + "]";
	}

}
