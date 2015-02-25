package alg.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HTTest {

	//Solution : 427
	public static void main(String[] args) throws FileNotFoundException{
		Scanner scanner = new Scanner(new File("/Users/skk/Desktop/coursera/testdata/algo1-programming_prob-2sum.txt"), "UTF-8");
		
		Map<Long,Integer> hm = new HashMap<>();
		while(scanner.hasNextLong()){
			long n=scanner.nextLong();
			int c=hm.get(n)==null?0:hm.get(n);
			hm.put(n,c+1);
		}
		
		System.out.println(sumExists(hm));
	}
	
	public static int sumExists(Map<Long,Integer> hm){
		int count=0;
		
		for(int target=-10000;target<=10000;target++){
			for(Long n:hm.keySet()){
				if(hm.get(target-n)==null)
					continue;
				if(n==(target-n) && hm.get(target-n)>1){
					count++;break;
				}else if(hm.get(target-n)>0){
					count++;break;
				}
			}
		}
		return count;
	}
}
