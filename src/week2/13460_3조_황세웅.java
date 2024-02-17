import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	static char[][] board;
	static int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][][][] visited;
	static int n, m;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		Board init = new Board(null, null, 0, -1);

		board = new char[n][m];
		for (int i = 0; i < n; i++) {
			board[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 'R') {
					init.setRed(i, j);
					board[i][j] = '.';
				}
				if (board[i][j] == 'B') {
					init.setBlue(i, j);
					board[i][j] = '.';
				}
			}
		}
		
		visited = new boolean[n][m][n][m];

		Queue<Board> queue = new LinkedList<>();
		queue.add(init);

		int ans = -1;
		while (!queue.isEmpty()) {
			Board curr = queue.poll();

			if (curr.depth > 10) {
				break;
			}
			if (curr.red.isGoal()) {
				ans = curr.depth;
				break;
			}
			
			visited[curr.red.row][curr.red.column][curr.blue.row][curr.blue.column] = true;

			for (int i = 0; i < 4; i++) {
				if (curr.prev == i) {
					continue;
				}

				Board next = curr.move(i);
				if (next.blue.isGoal()) {
					continue;
				}
				if (next.red.isGoal() || !visited[next.red.row][next.red.column][next.blue.row][next.blue.column]) {
					queue.add(next);					
				}
			}
		}

		System.out.println(ans);
	}

	static class Board {
		Pos red;
		Pos blue;
		int depth;
		int prev;

		public Board(Pos red, Pos blue, int depth, int prev) {
			this.red = red;
			this.blue = blue;
			this.depth = depth;
			this.prev = prev;
		}

		void setRed(int row, int column) {
			this.red = new Pos(row, column, true);
		}

		void setBlue(int row, int column) {
			this.blue = new Pos(row, column, false);
		}

		Board move(int dir) {
			Board next = new Board(red.clone(), blue.clone(), depth + 1, dir);

			if (red.isFirst(blue, direction[dir])) {
				next.red.move(direction[dir], next);
				next.blue.move(direction[dir], next);
			} else {
				next.blue.move(direction[dir], next);
				next.red.move(direction[dir], next);
			}

			return next;
		}

		class Pos {
			int row;
			int column;
			boolean isRed;

			public Pos(int row, int column, boolean isRed) {
				this.row = row;
				this.column = column;
				this.isRed = isRed;
			}

			public Pos clone() {
				return new Pos(this.row, this.column, this.isRed);
			}

			void move(int[] direction, Board next) {
				int nextRow = this.row;
				int nextColumn = this.column;

				while (true) {
					nextRow += direction[0];
					nextColumn += direction[1];

					if (board[nextRow][nextColumn] == 'O') {
						this.row = -1;
						this.column = -1;
						break;
					}
					if (board[nextRow][nextColumn] == '#') {
						this.row = nextRow - direction[0];
						this.column = nextColumn - direction[1];
						break;
					}
					if (isRed && next.blue.row == nextRow && next.blue.column == nextColumn) {
						this.row = nextRow - direction[0];
						this.column = nextColumn - direction[1];
						break;
					}
					if (!isRed && next.red.row == nextRow && next.red.column == nextColumn) {
						this.row = nextRow - direction[0];
						this.column = nextColumn - direction[1];
						break;
					}
				}
			}

			boolean isGoal() {
				return this.row == -1 && this.column == -1;
			}

			boolean isFirst(Pos target, int[] d) {
				if (d[0] == -1 && d[1] == 0) {
					return this.row < target.row ? true : false;
				}
				if (d[0] == 1 && d[1] == 0) {
					return this.row > target.row ? true : false;
				}
				if (d[0] == 0 && d[1] == -1) {
					return this.column < target.column ? true : false;
				}
				return this.column > target.column ? true : false;
			}
		}
	}
}