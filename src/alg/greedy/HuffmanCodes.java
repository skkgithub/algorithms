package alg.greedy;

import java.util.PriorityQueue;

public class HuffmanCodes {

	private char[] characterSet;
	private float[] frequencies;
	
	public HuffmanCodes(char[] c,float[] f){
		this.characterSet=c;this.frequencies=f;
	}
	
	public HTNode getHuffmanCodeTree(){
		PriorityQueue<HTNode> pq=new PriorityQueue<HTNode>();
		for(int i=0;i<characterSet.length;i++)
			pq.offer(new HTNode(characterSet[i], frequencies[i]));
		
		for(int i=1;i<characterSet.length;i++){
			HTNode right=pq.poll();
			HTNode left=pq.poll();
			HTNode z=new HTNode(left.getFrequency()+right.getFrequency());
			z.setLeft(left);z.setRight(right);
			pq.offer(z);
		}
		return pq.poll();
	}
	
	public String decode(HTNode r,String bc){
		if(r==null) return null;
		HTNode rn=r;
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<bc.length();i++){
			if(rn.getData()==null){
				rn=bc.charAt(i)=='1'?rn.getRight():rn.getLeft();
			}else{
				sb.append(rn.getData());i--;
				rn=r;
			}
		}
		sb.append(rn.getData());
		return sb.toString();
	}
	
	public static void main(String[] args){
		char[] c={'a','b','c','d'};
		float[] frequencies={33,25,22,20};
		HuffmanCodes hc=new HuffmanCodes(c, frequencies);
		HTNode r=hc.getHuffmanCodeTree();
		
		System.out.println(hc.decode(r, "011110"));
	}
}
