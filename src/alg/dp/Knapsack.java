package alg.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Dynamic Programming algorithm for knapsack problem to find optimal set of values.
 * 
 * @author saikiran
 */
public class Knapsack {

	private int[] v;
	private int[] w;
	private int capacity;
	private int[][] A;
	
	public Knapsack(int[] values,int[] weights, int capacity){
		this.v=values;this.w=weights;this.capacity=capacity;
	}
	
	public void findOptValues(){
		A=new int[v.length+1][capacity+1];
		for(int j=0;j<=capacity;j++){
			A[0][j]=0;
		}
		for(int i=1;i<=v.length;i++){
			for(int j=0;j<=capacity;j++){
				if(j-w[i-1]<0){
					A[i][j]=A[i-1][j];
					continue;
				}
				A[i][j]=max(A[i-1][j-w[i-1]]+v[i-1], A[i-1][j]);
			}
		}
	}
	
	public List<Integer> reconstruct(){
		List<Integer> kvalues=new ArrayList<>();
		int kc=capacity;
		for(int i=v.length;i>0;i--){
			if((kc-w[i-1])<0){
				continue;
			}
			if(A[i][kc-w[i-1]]+v[i-1] >= A[i][kc]){
				kvalues.add(v[i-1]);
				kc-=w[i-1];
			}
		}
		return kvalues;
	}
	
	private int max(int a,int b){
		return a>=b?a:b;
	}
	
	public static void main(String[] args){
		int[] v={60,100,120};int[] w={10,20,30};
		Knapsack k=new Knapsack(v, w, 19);
		k.findOptValues();
		System.out.println(k.reconstruct());
	}
}
