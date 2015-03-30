package alg.util;

public class MatrixUtil {

	public static void rotateMatrix(String[][] s,int N){
		for(int layer=0;layer<N/2;layer++){
			int first=layer,last=(N-1)-layer;
			
			for(int i=first;i<last;i++){
				int offset=i-first;
				String top=s[first][i];
				
				s[first][i]=s[last-offset][first];
				s[last-offset][first]=s[last][last-offset];
				s[last][last-offset]=s[i][last];
				s[i][last]=top;
			}
		}
	}
	
	public static String[][] rotateGeneralMatrix(String[][] s){
		int m=s.length,n=s[0].length;
		System.out.println(m);System.out.println(n);
		String[][] ts=new String[n][m];System.out.println(ts.length);
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				ts[j][(m-1)-i]=s[i][j];
			}
		}
		return ts;
	}
	
	public static void printMatrix(String[][] s){
		for(int i=0;i<s.length;i++){
			for(int j=0;j<s[0].length;j++)
				System.out.print(s[i][j]+" ");
			System.out.println();
		}
	}
	
	public static void main(String[] args){
		String[][] s={{"1","^","3"},{"4","|","6"},{"7","|","9"},{"10","|","12"}};
		printMatrix(s);System.out.println();
		//rotateMatrix(s, 3);
		
		printMatrix(rotateGeneralMatrix(s));
		
		for(int i=0;i<=0;i++){
			System.out.println("hey");
		}
	}
}
