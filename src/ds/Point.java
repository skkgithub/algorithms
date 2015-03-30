package ds;

import lombok.Getter;

@Getter
public class Point {

	private double x;
	private double y;
	
	public Point(double x1,double y1){
		this.x=x1;
		this.y=y1;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	
}
