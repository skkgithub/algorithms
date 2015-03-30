package ds.tree;

import java.util.ArrayList;

public class SuffixTree {

	SuffixTreeNode root = new SuffixTreeNode();

	public SuffixTree(String s) {
		for (int i = 0; i < s.length(); i++) {
			String suffix = s.substring(i);
			root.insertString(suffix, i);
		}
	}

	public ArrayList<Integer> getIndexes(String s) {
		return root.getIndexes(s);
	}

	public static void main(String[] args) {
		
		String testString = "mississippi";
		String[] stringList = { "is", "sip", "hi", "sis" };
		SuffixTree tree = new SuffixTree(testString);
		
		for (String s : stringList) {
			ArrayList<Integer> list = tree.getIndexes(s);
			if (list != null) {
				System.out.println(s + ": " + list.toString());
			}
		}
	}
}
