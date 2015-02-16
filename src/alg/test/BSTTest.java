package alg.test;

import ds.tree.BST;

public class BSTTest {

	public static void main(String[] args){
		BST bst=new BST();
		bst.insert(3);bst.insert(1);bst.insert(2);bst.insert(5);bst.insert(4);
		
		//bst.inorder();
		
		//System.out.println(bst.search(1));
		//System.out.println(bst.min());
		//System.out.println(bst.max());
		//System.out.println(bst.predecessor(2));
		//System.out.println(bst.successor(3));
		
		for(int i=1;i<6;i++){
			//System.out.println(bst.select(i));
			//System.out.println(bst.rank(i));
			//System.out.println(bst.predecessor(i));
			//System.out.println(bst.successor(i));
		}
		
		bst.delete(2);
		bst.inorder();
		System.out.println();
		bst.delete(3);
		bst.inorder();
	}
}
