import java.util.Scanner;

public class Main {
	// 이창현
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i]=sc.nextInt();
		}
		
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			int a = arr[i];
			for (int j = i+1; j < N; j++) {
				int b = arr[j];
				for (int k = j+1; k < N; k++) {
					int c = arr[k];
					max= (a+b+c)>M ? max: (a+b+c)>max? a+b+c:max;
				}
			}
		}
		System.out.println(max);
	}

}
