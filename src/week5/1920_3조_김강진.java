import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static int binarySearch(int[] a, int num, int first, int last) {
		int mid = (first+last)/2;
		
		
		if (first > last) {
			return 0;
		}
		
		if (num == a[mid] ){
			return 1;
		} else if (a[mid] > num){
			return binarySearch(a, num, first, mid -1);
		} else {
			return binarySearch(a, num, mid+1, last);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// Input N
		int n = Integer.parseInt(bf.readLine());
		
		// Input array A
		String str = bf.readLine();
		String aTmp[] = str.split(" ");
		
		int [] a = new int[n];
		
		for (int i=0;i<aTmp.length;i++) {
			a[i] = Integer.parseInt(aTmp[i]);
		}
		
		// Input M
		int m = Integer.parseInt(bf.readLine());
		
		//Input Array B
		str = bf.readLine();
		String bTmp[] = str.split(" ");
		
		int [] b = new int[m];
		for (int i=0; i<bTmp.length;i++) {
			b[i] = Integer.parseInt(bTmp[i]);
		}
		
		Arrays.sort(a);
		
		int first = 0;
		int last = a.length -1;
		
		for (int j=0;j<b.length;j++) {
			System.out.println(binarySearch(a,b[j],first,last));
		}
		
	}
}