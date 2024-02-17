#include <iostream>
#include <vector>
#include <string>
#include <utility>
#include <algorithm>
using namespace std;
using Pos = pair<int, int>;

constexpr int INF = 1'000'000'000;

int N, M;
vector<string> board;

enum Direction { UP = 0, DOWN, LEFT, RIGHT };

int dr[] = { -1, 1, 0, 0 };
int dc[] = { 0, 0, -1, 1 };

void moveBall(Pos& ball, Pos const& other, Direction d) {
	auto& [r, c] = ball;
	
	if (r == -1 && c == -1) return;
	
	while (true) {
	    if (board[r][c] == 'O') {
	        r = c = -1;
	        return;
	    }
	    if (board[r][c] == '#' || ball == other) {
	        r -= dr[d];
	        c -= dc[d];
	        return;
	    }
	    r += dr[d];
	    c += dc[d];
	}
}

int solveImpl(int depth, Pos red, Pos blue, Direction d) {
	if (depth == 11) return INF;
    
    auto chkGoal = [](Pos const& b) {
        return b == Pos{ -1, -1 };
    };

    bool red_goal = false, blue_goal = false;

	moveBall(red, blue, d);
	if (chkGoal(red)) red_goal = true;
	moveBall(blue, red, d);
	if (chkGoal(blue)) blue_goal = true;
	moveBall(red, blue, d);
	if (chkGoal(red)) red_goal = true;
	moveBall(blue, red, d);
	if (chkGoal(blue)) blue_goal = true;
	
	if (blue_goal) return INF;
	if (red_goal) return depth;

	int res = INF;
	for (int i = 0; i < 4; ++i) {
		if (i == (int)d) continue;
		res = min(res, solveImpl(depth + 1, red, blue, (Direction)i));
	}

	return res;
}

int solve() {
	int res = INF;
	
	Pos red, blue;
	for (int i = 0; i < N; ++i) {
	    for (int j = 0; j < M; ++j) {
	        if (board[i][j] == 'R') {
	            red = { i, j };
	            board[i][j] = '.';
	        }
	        else if (board[i][j] == 'B') {
	            blue = { i, j };
	            board[i][j] = '.';
	        }
	    }
	}
	
	for (int i = 0; i < 4; ++i) {
		res = min(res, solveImpl(1, red, blue, (Direction)i));
	}
	
	return res;
}

int main() {
    cin.tie(nullptr)->sync_with_stdio(false);
	cin >> N >> M; 
	board.assign(N, "");
	
	for (auto& s : board) cin >> s;

    int res = solve();
	cout << (res == INF ? -1 : res) << '\n';
}