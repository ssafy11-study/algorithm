import java.util.Scanner;

public class Main {
	public static int findGCD(int a, int b) {
		int minNum = a;
		if (minNum > b) {
			minNum = b;
		}
		
		for (int i=minNum;i>0;i--) {
//			System.out.println(i);
			if (a%i == 0 && b%i == 0) {
				return i;
			}
		}
		return 1;
	}
	
	public static int findLCM(int a, int b, int gcd) {
		return (a*b)/ gcd;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		// Input N
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int gcd = findGCD(a,b);
		System.out.println(gcd);
		
		int lcm = findLCM(a,b,gcd);
		System.out.println(lcm);
	}

}
