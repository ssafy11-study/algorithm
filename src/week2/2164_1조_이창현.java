import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
//이창현
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> Q = new LinkedList<>();
	
		for(int i = 1; i <= N; i++) {
			Q.add(i);
		}
		
		while(true) {
			int result = Q.poll();	// 첫번째 값 삭제 및 저장
			if(Q.peek()==null) {	// 첫번째 값 삭제 후 다음 값 null인지 확인
				System.out.println(result);
				break;
			}else {
				Q.add(Q.poll());	//첫 번재 값 삭제 후 그 다음 값을 가장 뒤로 이동
			}
		}
	}
}
