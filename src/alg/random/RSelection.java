package alg.random;

import java.util.Random;

import alg.util.ArrayUtility;

public class RSelection {

	public int orderStatistic(int[] array, int os){
		return orderStatistic(array, 0, array.length-1, os);
	}
	
	private int orderStatistic(int[] array, int lower, int higher, int os){
		if(lower>higher){
			System.out.println("lower: "+lower+" higher: "+higher);
		}
		if(lower==higher)
			return array[lower];
		
		int pivot=getRandomPivot(lower,higher);
		pivot=partition(array, pivot, lower, higher);
		
		if((pivot+1)==os)
			return array[pivot];
		
		if((pivot+1)<os)
			return orderStatistic(array, pivot+1, higher, os);
		else
			return orderStatistic(array, lower, pivot-1, os);
	}
	
	private int partition(int[] a,int pivot,int lower,int higher){
		swap(a, pivot, lower);
		
		int i=lower,j=lower;
		while(j<higher){
			if(a[j+1]>a[lower]){
				j++;
			}
			else{
				swap(a, i+1, j+1);
				i++;j++;
			}
		}
		swap(a, i, lower);
		
		return i;
	}
	
	private void swap(int[] a, int i, int j){
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	
	private int getRandomPivot(int lower,int higher){
		Random r= new Random();
		return r.nextInt(higher-lower+1)+lower;
	}
	
	public static void main(String[] args){
		//int[] a=ArrayUtility.getRandomArray(10);
		int[] a={5,3,9,8,1,2,4,7,0,6};
		ArrayUtility.printArray(a);
		RSelection rs=new RSelection();
		System.out.println(rs.orderStatistic(a,9));
	}
}
