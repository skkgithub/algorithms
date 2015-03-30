package alg.cc.sorting;

import alg.util.ArrayUtility;

public class MergeArrays {

	public static void merge(int[] A,int end,int[] B){
		for(int i=0;i<B.length;i++){
			int index=search(A, 0, end, B[i]);
			insert(A, end, index, B[i]);
			end++;
		}
	}
	public static void mergeSorted(int[] A,int end,int[] B){
		int ai=0,bi=0;
		while(bi<B.length && ai<=end){
			if(A[ai]>=B[bi]){
				insert(A,end,ai,B[bi]);
				end++;bi++;
			}
			ai++;
		}
		if(bi<B.length){
			for(int i=bi;i<B.length;i++){
				A[end+1]=B[i];
				end++;
			}
				
		}
	}
	private static int search(int[] A,int start, int end,int x){
		if(end-start<=1){
			if(x>A[start]){
				if(x>A[end])
					return end+1;
				else return end;
			}else
				return start;
		}
		
		int mid=start+(end-start)/2;
		if(A[mid]<x)
			return search(A,mid,end,x);
		else
			return search(A,start,mid,x);
	}
	
	private static void insert(int[] A,int end, int index, int x){
		for(int i=end;i>=index;i--)
			A[i+1]=A[i];
		A[index]=x;
	}
	
	public static void main(String[] args){
		int[] A=new int[20];
		A[0]=1;A[1]=2;A[2]=4;A[3]=8;
		int[] B={0,3,4,7,9};
		
		//merge(A, 3, B);
		mergeSorted(A, 3, B);
		ArrayUtility.printArray(A);
		
	}
}
