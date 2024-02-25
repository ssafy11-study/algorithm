#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

constexpr int INF = 1'000'000'000;

struct Pos {
	int r, c;

	int dist(Pos const& p) const {
		return abs(r - p.r) + abs(c - p.c);
	}
};

struct Info {
	int pc1, pc2;
};

vector<Pos> incident;
vector<vector<int>> dp;
vector<vector<Info>> mem;

int N, M;

int topDown(int pc1, int pc2, Pos pc1_pos, Pos pc2_pos) {
	if (pc1 == M || pc2 == M) return 0;
	if (dp[pc1][pc2] != INF) return dp[pc1][pc2];

	int nxt = max(pc1, pc2) + 1;

	dp[pc1][pc2] = pc1_pos.dist(incident[nxt]) + topDown(nxt, pc2, incident[nxt], pc2_pos);
	mem[pc1][pc2] = { nxt, pc2 };

	int other = pc2_pos.dist(incident[nxt]) + topDown(pc1, nxt, pc1_pos, incident[nxt]);
	if (other < dp[pc1][pc2]) {
		dp[pc1][pc2] = other;
		mem[pc1][pc2] = { pc1, nxt };
	}

	return dp[pc1][pc2];
}

int main() {
	cin.tie(nullptr)->sync_with_stdio(false);
	cin >> N >> M;

	incident.assign(M + 1, {});
	dp.assign(M + 1, vector<int>(M + 1, INF));
	mem.assign(M + 1, vector<Info>(M + 1, { -1, -1 }));

	for (int i = 1; i <= M; ++i) cin >> incident[i].r >> incident[i].c;
	int res = topDown(0, 0, { 1, 1 }, { N, N });

	cout << res << '\n';
	Info info{ 0, 0 };
	for (int i = 1; i <= M; ++i) {
		auto& nxt = mem[info.pc1][info.pc2];
		if (nxt.pc1 > info.pc1) {
			cout << "1\n";
		}
		else {
			cout << "2\n";
		}
		info = nxt;
	}
}