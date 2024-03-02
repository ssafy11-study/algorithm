#include <iostream>
#include <vector>
using namespace std;

constexpr int N = 21;
constexpr int R = 6;
constexpr int C = 7;

char board[R][C];
int bottom_cnt[C];

char sk = 's';
char ji = 'j';

bool chkBound(int r, int c) {
	return 0 <= r && r < R && 0 <= c && c < C;
}

bool chkWin(int r, int c, char player) {
	
	// 세로 카운트
	int cnt = 1;
	int nr = r - 1, nc = c;

	while (chkBound(nr, nc) && board[nr][nc] == player) {
		++cnt;
		--nr;
	}

	if (cnt >= 4) return true;

	// 우하, 좌상 대각 카운트

	cnt = 1;
	nr = r - 1;
	nc = c + 1;

	while (chkBound(nr, nc) && board[nr][nc] == player) {
		++cnt;
		--nr;
		++nc;
	}

	nr = r + 1;
	nc = c - 1;

	while (chkBound(nr, nc) && board[nr][nc] == player) {
		++cnt;
		++nr;
		--nc;
	}

	if (cnt >= 4) return true;

	// 좌하, 우상 대각 카운트

	cnt = 1;
	nr = r - 1;
	nc = c - 1;

	while (chkBound(nr, nc) && board[nr][nc] == player) {
		++cnt;
		--nr;
		--nc;
	}

	nr = r + 1;
	nc = c + 1;

	while (chkBound(nr, nc) && board[nr][nc] == player) {
		++cnt;
		++nr;
		++nc;
	}

	if (cnt >= 4) return true;

	// 가로 카운트

	cnt = 1;
	nr = r;
	nc = c - 1;

	while (chkBound(nr, nc) && board[nr][nc] == player) {
		++cnt;
		--nc;
	}

	nc = c + 1;
	while (chkBound(nr, nc) && board[nr][nc] == player) {
		++cnt;
		++nc;
	}

	return cnt >= 4;
}

int main() {
	cin.tie(nullptr)->sync_with_stdio(false);

	for (int i = 1; i <= N; ++i) {
		int s, j; cin >> s >> j;
		--s; --j;

		board[bottom_cnt[s]++][s] = sk;
		if (chkWin(bottom_cnt[s] - 1, s, sk)) {
			cout << "sk " << i << '\n';
			return 0;
		}

		board[bottom_cnt[j]++][j] = ji;
		if (chkWin(bottom_cnt[j] - 1, j, ji)) {
			cout << "ji " << i << '\n';
			return 0;
		}
	}

	cout << "ss\n";
}