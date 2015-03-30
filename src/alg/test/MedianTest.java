package alg.test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ds.Point;

public class MedianTest {

	//Solution: 46831213
	// 4,4,4.4,2,5,5 = 24.4
	// 5,5,5,5,5,5 = 30
	public static void main(String[] args) throws FileNotFoundException{
//		Scanner scanner = new Scanner(new File("/Users/skk/Desktop/coursera/testdata/Median.txt"), "UTF-8");
//		
//		MedianTracker mt=new MedianTracker();
//		int sum=0;int count=0;
//		while(scanner.hasNextInt()){
//			sum+=mt.insert(scanner.nextInt());
//			count++;
//		}
//		System.out.println(sum);
//		System.out.println(count);
		
		Point c1=new Point(25,125);
		Point c2=new Point(44,105);
		Point c3=new Point(29,97);
		Point c4=new Point(35,63);
		Point c5=new Point(55,63);
		Point c6=new Point(42,57);
		Point c7=new Point(23,40);
		Point c8=new Point(64,37);
		Point c9=new Point(33,22);
		Point c10=new Point(55,20);
		Point[] cpoints={c1,c2,c3,c4,c5,c6,c7,c8,c9,c10};
		Point x1=new Point(28,145);
		Point x2=new Point(38,115);
		Point x3=new Point(50,130);
		Point x4=new Point(65,140);
		Point x5=new Point(55,118);
		Point x6=new Point(43,83);
		Point x7=new Point(50,90);
		Point x8=new Point(63,88);
		Point x9=new Point(50,60);
		Point x10=new Point(50,30);
		
		Point[] xpoints={x1,x2,x3,x4,x5,x6,x7,x8,x9,x10};
		Map<Point,List<Point>> clusters=new HashMap<Point, List<Point>>();
		
		for(Point c:cpoints){
			clusters.put(c, new ArrayList<Point>());
		}
		for(Point p:xpoints){
			double sd=Double.POSITIVE_INFINITY;
			Point sp=null;
			for(Point c:cpoints){
				double dist=dist(p, c);
				if(sd>dist){
					sd=dist;
					sp=c;
				}
			}
			clusters.get(sp).add(p);
		}
		
		System.out.println(clusters);
		Map<Point,Point> centroids=new HashMap<Point, Point>();
		System.out.println(clusters.size());
		for(Point c:clusters.keySet()){
			centroids.put(c, centroid(clusters.get(c),c));
		}
		System.out.println(centroids);
		for(Point p:centroids.keySet()){
			System.out.println(centroids.get(p));
		}
	}
	
	public static Point centroid(List<Point> points,Point c){
		int size=points.size()+1;
		double x=0;double y=0;
		for(Point p:points){
			x+=p.getX();y+=p.getY();
		}
		x+=c.getX();y+=c.getY();
		return new Point(x/size,y/size);
	}
	
	public static double dist(Point p1, Point p2){
		return Math.sqrt(Math.pow(p1.getX()-p2.getX(),2)+Math.pow(p1.getY()-p2.getY(), 2));
	}
	
}
