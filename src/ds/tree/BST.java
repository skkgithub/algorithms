package ds.tree;


public class BST {

	private Node root;
	
	public int size(){
		return size(root);
	}
	
	public int size(Node n){
		return n==null?0:n.getSize();
	}
	
	public Node search(int key){
		return search(key, root);
	}
	
	private Node search(int key,Node n){
		if(n==null)
			return null;
		if(key==n.getKey())
			return n;
		if(key<n.getKey()){
			return search(key,n.getLeft());
		}else{
			return search(key,n.getRight());
		}
	}
	
	public void insert(int key){
		if(root==null){
			this.root=new Node(key, 1);
			root.setParent(null);
			return;
		}
		insert(key,root);
	}
	
	public void insert(int key,Node n){
		if(key<n.getKey()){
			if(n.getLeft()==null){
				Node c=new Node(key, 1);
				n.setLeft(c);c.setParent(n);
			}else{
				insert(key,n.getLeft());
			}
		}else{
			if(n.getRight()==null){
				Node c=new Node(key, 1);
				n.setRight(c);c.setParent(n);
			}else{
				insert(key,n.getRight());
			}
		}
		n.setSize(size(n.getLeft())+size(n.getRight())+1);
	}
	
	public Node min(){
		if(root==null){
			return null;
		}
		return min(root);
	}
	
	private Node min(Node n){
		if(n.getLeft()==null){
			return n;
		}
		return min(n.getLeft());
	}
	
	public Node max(){
		if(root==null){
			return null;
		}
		return max(root);
	}
	
	private Node max(Node n){
		if(n.getRight()==null){
			return n;
		}
		return max(n.getRight());
	}
	
	public Node predecessor(int key){
		Node n=search(key);
		if(n==null)
			return null;
		if(n.getLeft()!=null)
			return max(n.getLeft());
		Node p=n;
		while(p.getParent()!=null){
			if(p.getParent().getKey()<n.getKey())
				return p.getParent();
			p=p.getParent();
		}
		return null;
	}
	
	public Node successor(int key){
		Node n=search(key);
		if(n==null)
			return null;
		if(n.getRight()!=null)
			return min(n.getRight());
		Node p=n;
		while(p.getParent()!=null){
			if(p.getParent().getKey()>n.getKey())
				return p.getParent();
			p=p.getParent();
		}
		return null;
	}
	
	public Node select(int orderStatistic){
		if(root==null || orderStatistic>root.getSize())
			return null;
		return select(orderStatistic, root);
	}
	
	private Node select(int os,Node n){
		int k=n.getLeft()==null?0:n.getLeft().getSize();
		if(k+1==os)
			return n;
		if(k>=os)
			return select(os,n.getLeft());
		else
			return select(os-(k+1),n.getRight());
	}
	
	public int rank(int key){
		return rank(key,root);
	}
	
	private int rank(int key,Node n){
		int rank=n.getLeft()==null?1:n.getLeft().getSize()+1;
		if(key==n.getKey())
			return rank;
		if(key<n.getKey())
			return rank(key,n.getLeft());
		else
			return rank+rank(key,n.getRight());
	}
	
	public void inorder(){
		inorder(root);
	}
	private void inorder(Node n){
		if(n==null)
			return;
		inorder(n.getLeft());
		//System.out.println(n.getKey()+" ");
		System.out.println(n);
		inorder(n.getRight());
	}
	
	public void delete(int key){
		Node n=search(key);
		if(n==null)
			return;
		if(n.getLeft()==null && n.getRight()==null){
			decreseSize(n);
			if(n.getParent().getKey()>n.getKey())
				n.getParent().setLeft(null);
			else
				n.getParent().setRight(null);
		}else if(n.getLeft()==null){
			decreseSize(n);
			if(n.getParent().getKey()>n.getRight().getKey())
				n.getParent().setLeft(n.getRight());
			else
				n.getParent().setRight(n.getRight());
			n.getRight().setParent(n.getParent());
		}else if(n.getRight()==null){
			decreseSize(n);
			if(n.getParent().getKey()>n.getLeft().getKey())
				n.getParent().setLeft(n.getLeft());
			else
				n.getParent().setRight(n.getLeft());
			n.getLeft().setParent(n.getParent());
		}else{
			Node pred=predecessor(key);
			decreseSize(pred);
			pred.setLeft(n.getLeft().getKey()==pred.getKey()?null:n.getLeft());
			pred.setRight(n.getRight().getKey()==pred.getKey()?null:n.getRight());
			pred.setSize(n.getSize());
			n.getLeft().setParent(pred);n.getRight().setParent(pred);
			if(n.getKey()==root.getKey()){
				this.root=pred;pred.setParent(null);
			}
			
			Node predp=pred.getParent();
			if(predp==null)
				return;
			if(predp.getKey()>pred.getKey())
				predp.setLeft(null);
			else
				predp.setRight(null);
			pred.setParent(n.getParent());
		}
			
	}
	private void decreseSize(Node n){
		if(n==null)
			return;
		n.setSize(n.getSize()-1);
		decreseSize(n.getParent());
	}
	
	int llh=0,lhh=0;
	public boolean isBalanced(){
		if(root==null) return true;
		traverseTrackHeight(root, 0);
		System.out.println(lhh);
		System.out.println(llh);
		return lhh-llh<=1;
	}
	
	private void traverseTrackHeight(Node n,int h){
		if(n.getLeft()==null && n.getRight()==null){
			updateHeightBounds(h);
			return;
		}
		if(n.getLeft()!=null)	traverseTrackHeight(n.getLeft(), h+1);
		if(n.getRight()!=null)	traverseTrackHeight(n.getRight(), h+1);
	}
	private void updateHeightBounds(int h){
		if(lhh==0 && llh==0){
			llh=h;lhh=h;
		}
		if(lhh<h)	lhh=h;
		else if(llh>h)	llh=h;
	}
}
