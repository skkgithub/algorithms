package alg.string;

import java.util.LinkedHashMap;

public class Test {

	public static void main(String[] args){
		LinkedHashMap<Character, Integer> map=new LinkedHashMap<Character, Integer>();
		map.put('a', 3);
		map.put('b', 5);
		map.put('c', 2);
		map.put('d', 1);
		
		System.out.println(map.keySet());
	}
}
