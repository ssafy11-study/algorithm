#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

using ll = long long;

int main() {
	cin.tie(nullptr)->sync_with_stdio(false);
	int N, M; cin >> N >> M;

	vector<vector<int>> map(N, vector<int>(N));
	vector<int> order(M);

	for (auto& n : order) { cin >> n; --n; }
	for (auto& i : map) for (auto& j : i) cin >> j;

	for (int k = 0; k < N; ++k) {
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				map[i][j] = min(map[i][j], map[i][k] + map[k][j]);
			}
		}
	}

	ll res = 0;
	for (int i = 0; i < (int)order.size() - 1; ++i) {
		res += map[order[i]][order[i + 1]];
	}

	cout << res << '\n';
}