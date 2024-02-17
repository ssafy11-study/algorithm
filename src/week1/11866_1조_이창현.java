import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		List<Integer> arr= new LinkedList<Integer>();
		
		for (int i = 0; i < N; i++) {
			arr.add(i+1);
		}
	
		int x =K-1;
		
		System.out.print("<");
		
		while(true) {
			System.out.print(arr.remove(x)); 
			if(arr.size()>0) {
				x = (x+K-1)%arr.size();
				System.out.print(", ");
			} else {
				break;
			}
		}
		
		System.out.println(">");
		
	}

}