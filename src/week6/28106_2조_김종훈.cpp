#include <iostream>
#include <vector>
#include <queue>
using namespace std;

constexpr int MOD = 998'244'353;

vector<int> P;
vector<int> A;
vector<int> in_deg;
vector<int> dp;
int root = -1;

void up(int n, int depth, int const& val) {
	if (A[n] >= depth) {
		dp[n] = (dp[n] + val) % MOD;
	}
	if (P[n] != -1) up(P[n], depth + 1, val);
}

int main() {
	cin.tie(nullptr)->sync_with_stdio(false);
	int N; cin >> N;
	P.assign(N + 1, -1);
	A.assign(N + 1, 0);
	in_deg.assign(N + 1, 0);
	dp.assign(N + 1, 0);

	for (int i = 1; i <= N; ++i) {
		cin >> P[i];
		++in_deg[P[i]];
		if (P[i] == 0) root = i;
	}

	for (int i = 1; i <= N; ++i) {
		cin >> A[i];
	}

	queue<int> q;
	for (int i = 1; i <= N; ++i) {
		if (in_deg[i] == 0) {
			q.push(i);
			dp[i] = 1;
		}
	}

	while (!q.empty()) {
		int n = q.front(); q.pop();

		if (P[n] == -1) continue;
		up(P[n], 1, dp[n]);

		if (--in_deg[P[n]] == 0) {
			q.push(P[n]);
		}
	}

	cout << dp[root] << '\n';
}