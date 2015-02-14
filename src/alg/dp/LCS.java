package alg.dp;

/**
 * Dynamic programming algorithm to find 'Longest Common Subsequence' from given two Strings
 * 
 * @author saikiran
 */
public class LCS {

	private String x;
	private String y;
	private int[][] A;
	
	public LCS(String x, String y){
		this.x=x;this.y=y;
	}
	
	public int findLCSLength(){
		int length=0;
		if(x==null || x.isEmpty() || y==null || y.isEmpty())
			return length;

		A=new int[x.length()+1][y.length()+1];
		for(int i=0;i<=x.length();i++)
			A[i][0]=0;
		for(int j=0;j<=y.length();j++)
			A[0][j]=0;
		
		for(int i=1;i<=x.length();i++){
			for(int j=1;j<=y.length();j++){
				if(x.charAt(i-1)==y.charAt(j-1)){
					A[i][j]=A[i-1][j-1]+1;
				}else{
					A[i][j]=max(A[i-1][j], A[i][j-1]);
				}
					
			}
		}
		for(int i=0;i<=x.length();i++){
			for(int j=0;j<=y.length();j++){
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
		return A[x.length()][y.length()];
	}
	
	public String reconstruct(){
		StringBuilder sb=new StringBuilder();
		int i=x.length();int j=y.length();
		while(i>0 && j>0){
			if(x.charAt(i-1)==y.charAt(j-1)){
				sb.append(x.charAt(i-1));i--;j--;
			}else{
				if(A[i-1][j]>=A[i][j-1]){
					i--;
				}else{
					j--;
				}
			}
		}
		return sb.reverse().toString();
	}
	
	private int max(int a,int b){
		return a>=b?a:b;
	}
	
	public static void main(String[] args){
		String x="ABCBDAB",y="YDBDCABA";
		LCS lcs=new LCS(x, y);
		System.out.println(lcs.findLCSLength());
		System.out.println(lcs.reconstruct());
	}
}
