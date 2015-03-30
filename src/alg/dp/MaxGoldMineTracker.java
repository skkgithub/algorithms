package alg.dp;


public class MaxGoldMineTracker {

	private int[][] f;
	
	public void maxGold(int[][] g){
		int i=g.length, j=g[0].length;
		System.out.println("rows : "+i+" columns:"+j);
		f=new int[i][j];
		for(int r=0;r<i;r++)
			maxGoldForRow(g,r, 0);
		print2DArray(f);
	}
	
	private int maxGoldForRow(int[][] g,int i,int j){
		if(f[i][j]>0) return f[i][j];
		
		int c1=g[i][j],c2=g[i][j];
		
		if(i>0 && j<f[0].length-1){
			c1+=maxGoldForRow(g,i-1, j+1);
		}
		if(i<f.length-1 && j<f[0].length-1){
			c2+=maxGoldForRow(g,i+1, j+1);
		}

		if(c1>c2){
			f[i][j]=c1;
			return c1;
		}else{
			f[i][j]=c2;
			return c2;
		}
	}
	
	private void print2DArray(int[][] a){
		int i=a.length,j=a[0].length;
		
		for(int r=0;r<i;r++){
			for(int c=0;c<j;c++)
				System.out.print(a[r][c]+" ");
			System.out.println();
		}
	}
	
	public static void main(String[] args){
		int[][] g={{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
		MaxGoldMineTracker mt=new MaxGoldMineTracker();
		mt.maxGold(g);
	}
}
