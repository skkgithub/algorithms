package alg.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;

public class StringUtil {

	public static boolean areAnagrams(String s1,String s2){
		if(s1==null || s2==null) return false;
		return sortStringChars(s1).equals(s2);
	}
	
	public static String sortStringChars(String s){
		char[] c=s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
	
	public static void printDuplicates(String s){
		//int[] c=new int[256];
		StringBuffer sb=new StringBuffer(s);
		boolean[] c =new boolean[256];
		for(int i=0;i<sb.length();i++){
			if(c[sb.charAt(i)]==true){
				System.out.println(sb.charAt(i));
				sb.deleteCharAt(i);i--;
			}
			c[sb.charAt(i)]=true;
		}
		System.out.println(sb.toString());
	}
	
	public static boolean isSubString(String s1,String s2){
		if(s1==null || s2==null || s1.length()>s2.length()) return false;
		for(int i=0;i<s2.length();i++){
			int j;
			for(j=0;j<s1.length();j++){
				if(s2.charAt(i+j)!=s1.charAt(j)) break;
			}
			if(j==s1.length()) return true;
		}
		return false;
	}
	
	public static boolean isRotation(String s1,String s2){
		return isSubString(s2, s1.concat(s1));
	}
	
	public static void printAllParanthesis(int N){
		printAllParanthesis(0, new String(), 0, 0,N);
	}
	
	private static void printAllParanthesis(int pairs,String cString,int lb,int rb,int N){
		if(pairs==N){
			System.out.println(cString);return;
		}
		if(lb<N)
			printAllParanthesis(pairs,cString+"(",lb+1,rb,N);
		if(lb>rb)
			printAllParanthesis(pairs+1,cString+")",lb,rb+1,N);
	}
	
	public static void printAllSubsets(ArrayList<String> a){
		for(int i=0;i<a.size();i++){
			String s=a.get(i);
			printAllSubsetsWithString(a, s, i);
		}
	}
	
	private static void printAllSubsetsWithString(ArrayList<String> a,String s,int index){
		System.out.println(s);
		
		for(int i=index+1;i<a.size();i++){
			printAllSubsetsWithString(a, s+","+a.get(i), i);
		}
	}
	
	public static int count(int n){
			 // Base case
			if (n == 0) return 0;
			
			 // 513 into 5 * 100 + 13. [Power = 100; First = 5; Remainder = 13]
			 int power = 1;
			 while (10 * power < n) power *= 10;
			 int first = n / power;
			 int remainder = n % power;
			 int nTwosFirst = 0;
			  if (first > 2) nTwosFirst += power;
			  else if (first == 2) nTwosFirst += remainder + 1;
			 
			  // Count 2s from all other digits
			  int nTwosOther = first * count(power - 1) + count(remainder);
			 
			  return nTwosFirst + nTwosOther;
			  

	}
	
	public static void main(String[] args){
		System.out.println(Integer.MAX_VALUE);
		System.out.println(0x1);
	}
}
