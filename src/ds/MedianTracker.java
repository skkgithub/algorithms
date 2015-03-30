package ds;

import java.util.Collections;
import java.util.PriorityQueue;

import lombok.Getter;

@Getter
public class MedianTracker {

	private PriorityQueue<Integer> lowHeap;
	private PriorityQueue<Integer> highHeap;
	
	public MedianTracker(){
		lowHeap=new PriorityQueue<Integer>(Collections.reverseOrder());
		highHeap=new PriorityQueue<Integer>();
	}
	
	public int insert(Integer x){
		 if(lowHeap.isEmpty() || x<lowHeap.peek()){
			 lowHeap.offer(x);
		 }else{
			 highHeap.offer(x);
		 }
		 balance();
		 return getMedian();
	}
	
	public void balance(){
		if(lowHeap.size()-highHeap.size() >= 2){
			highHeap.offer(lowHeap.poll());
		}else if(highHeap.size()-lowHeap.size() >= 2){
			lowHeap.offer(highHeap.poll());
		}
	}
	
	public int getMedian(){
		int medianIndex=(size()+1)/2;
		if(lowHeap.size()==medianIndex){
			return lowHeap.peek();
		}else{
			return highHeap.peek();
		}
	}
	
	public int size(){
		return lowHeap.size()+highHeap.size();
	}
	
	public static void main(String[] args){
		//int[] a={6331,2793,1640,9290,225,625};
		int[] a={1,2,3,4,5};
		MedianTracker mt=new MedianTracker();
		
		for(int x:a){
			System.out.println(mt.insert(x));
			//System.out.println(mt.getLowHeap());
			//System.out.println(mt.getHighHeap());
		}
	}
}
