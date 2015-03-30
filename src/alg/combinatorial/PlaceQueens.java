package alg.combinatorial;

import alg.util.ArrayUtility;

public class PlaceQueens {

	private int[] x;
	public PlaceQueens(int n){
		x=new int[n];
		for(int i=0;i<n;i++)
			x[i]=-1;
	}
	
	public int[] place(){
		place(0);
		return x;
	}
	public void place(int k){
		if(k<0 || k>=x.length)
			return;
		reset(k+1);
		for(int c=x[k]+1;c<x.length;c++){
			if(isValidPlace(k,c)){
				x[k]=c;
				place(k+1);
				break;
			}
		}
		if(x[x.length-1]==-1)
			place(k-1);
	}
	
	private boolean isValidPlace(int m, int n){
		if(m>=x.length || n>x.length)
			return false;
		for(int i=0;i<m;i++){
			if(x[i]==n || Math.abs(m-i)==Math.abs(n-x[i]))
				return false;
		}
		return true;
	}
	
	private void reset(int k){
		if(k>=x.length)
			return;
		for(int i=k;i<x.length;i++)
			x[k]=-1;
	}
	public static void main(String[] args){
		PlaceQueens pq=new PlaceQueens(8);
		
		ArrayUtility.printArray(pq.place());
	}
}
