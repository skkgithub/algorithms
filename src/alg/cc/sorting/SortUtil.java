package alg.cc.sorting;

public class SortUtil {

	public static int findElementInRotatedArray(int[] A,int x){
		int l=0,u=A.length-1;
		
		while(l<=u){
			int mid=(l+u)/2;
			if(A[mid]==x)	return mid;
			if(A[l]<=A[mid]){
				if(x>A[mid])
					l=mid+1;
				else if(x>=A[l])
					u=mid-1;
				else
					l=mid+1;
			}
			else if(x<A[mid])	u=mid-1;
			else if(x<A[l])		l=mid+1;
			else				u=mid-1;
		}
		return -1;
	}
	
	public static int findMaxSortedSubArrayLength(int[] A){
		int lph=0,c=1;
		for(int i=1;i<A.length;i++){
			if(A[i]>A[i-1])
				c++;
			else{
				lph=lph>c?lph:c;c=1;
			}
		}
		lph=lph>c?lph:c;
		return lph;
	}
	
	public static int nways(int csum,int n){
		if(csum>n)	return 0;
		if(csum==n)	return 1;
		
		return nways(csum+5,n)+nways(csum+10,n)+nways(csum+25,n)+nways(csum+1,n);
	}
	
	public static int makeChange(int n, int denom) { int next_denom = 0;
		switch (denom) {
		case 25:
		next_denom = 10;
		        break;
		    case 10:
		next_denom = 5;
		        break;
		    case 5:
		next_denom = 1;
		        break;
		    case 1:
		return 1; }
		int ways = 0; 
		for(int i=0;i*denom<=n;i++){
		ways += makeChange(n - i * denom, next_denom); }
		return ways; 
	}
	public static int gcd(int p,int q){
		if (q == 0) return p;
        else return gcd(q, p % q);
	}
	public static void main(String[] args){
		System.out.println(gcd(108,96));
		System.out.println(5^2);
	}
}
