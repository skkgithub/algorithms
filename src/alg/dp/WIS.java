package alg.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Dynamic Programming Algorithm with memoization to find Maximum Weighted Independent set
 * in a Path Graph.
 * 
 * @author saikiran
 */
public class WIS {

	private double[] weights;
	private double[] A;
	
	public WIS(double[] weights){
		this.weights=weights;
		A=new double[weights.length+1];
	}
	
	public void findMaxWeightIS(){
		A[0]=0;A[1]=weights[0];
		
		for(int i=2;i<A.length;i++){
			A[i]=A[i-1]>A[i-2]+weights[i-1]?A[i-1]:A[i-2]+weights[i-1];
		}
		
		System.out.println(A[A.length-1]);
	}
	
	public List<Integer> reconstruct(){
		List<Integer> wis=new ArrayList<>();
		int i=A.length-1;
		while(i>=2){
			if(A[i-1]>(A[i-2]+weights[i-1])){
				i-=1;
			}else{
				wis.add(i);
				i-=2;
			}
		}
		return wis;
	}
	
	public static void main(String[] args){
		double[] weights={1,4,5,4};
		WIS wis=new WIS(weights);
		wis.findMaxWeightIS();
		System.out.println(wis.reconstruct());
	}
}
