package alg.combinatorial;

import alg.util.ArrayUtility;

public class PermutationGenerator {

	public static int[] nextLexicalPermutation(int[] array){
		if(array==null || array.length==1)
			return null;
		int pivot=-1;
		for(int i=array.length-1;i>0;i--){
			if(array[i]>array[i-1]){
				pivot=i-1;
				break;
			}
		}
		if(pivot==-1)
			return null;
		
		int psuffix=pivot+1;
		for(int i=pivot+2;i<array.length;i++){
			if(array[psuffix]>=array[i] && array[i]>array[pivot])
				psuffix=i;
		}
		swap(array,pivot,psuffix);
		reverse(array, pivot+1, array.length-1);
		
		return array;
	}
	
	private static void swap(int[] n,int i,int j){
		int temp=n[i];
		n[i]=n[j];n[j]=temp;
	}
	
	private static void reverse(int[] n, int i,int j){
		while(i<j){
			swap(n,i,j);
			i++;j--;
		}
	}
	
	public static void main(String[] args){
		int[] a={1,1,3};
		ArrayUtility.printArray(a);
		while(PermutationGenerator.nextLexicalPermutation(a)!=null){
			ArrayUtility.printArray(a);
		}
	}
}
