import java.util.Scanner;

public class Main {			//이창현
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double[] arr = new double[N];
		double max = 0;
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
			max=(max>arr[i])? max:arr[i];
		}
		
		double sum = 0;
		
		for(int i=0; i<N; i++) {
			arr[i] = arr[i] /max*100;
			sum+=arr[i];
		}
		double result = sum/N;
		System.out.println(result);
	}

}