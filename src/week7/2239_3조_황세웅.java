import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[][] map = new int[9][9];
	static List<Pos> pos = new ArrayList<>();
	static boolean done;

	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 9; i++) {
			String input = br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = input.charAt(j) - '0';
				if (map[i][j] == 0) pos.add(new Pos(i, j));
			}
		}
				
		backtracking(0);
		System.out.println(sb);
	}
	
	static void backtracking(int cnt) {
		if (cnt == pos.size()) {
			done = true;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			return;
		}
		for (int i = 1; i < 10; i++) {
			Pos curr = pos.get(cnt);
			if (!check(curr.r, curr.c, i)) continue;
			map[curr.r][curr.c] = i;
			backtracking(cnt + 1);
			if (done) return;
			map[curr.r][curr.c] = 0;
		}
	}
	
	static boolean check(int r, int c, int v) {
		for (int tr = 0; tr < 9; tr++) {
			if (tr == r) continue;
			if (map[tr][c] == v) return false;
		}
		for (int tc = 0; tc < 9; tc++) {
			if (tc == c) continue;
			if (map[r][tc] == v) return false;
		}
		
		int sr = (r / 3) * 3;
		int sc = (c / 3) * 3;
		for (int tr = sr; tr < sr + 3; tr++) {
			for (int tc = sc; tc < sc + 3; tc++) {
				if (tr == r && tc == c) continue;
				if (map[tr][tc] == v) return false;
			}
		}
		return true;
	}
	
	static class Pos {
		int r;
		int c;
		
		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}