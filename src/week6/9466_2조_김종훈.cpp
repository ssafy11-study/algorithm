#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false); cin.tie(nullptr);
	int TC; cin >> TC;
	for (int tc = 0; tc < TC; ++tc) {
		int N, result = 0; cin >> N;
		vector<vector<int>> graph(N, vector<int>{});
		vector<int> in(N, 0);
		for (int i = 0; i < N; ++i) {
			int n; cin >> n;
			graph[i].push_back(n - 1); ++in[n - 1];
		}
		queue<int> q;
		for (int i = 0; i < N; ++i) if (in[i] == 0) q.push(i);
		while (!q.empty()) {
			++result;
			auto n = q.front(); q.pop();
			for (auto& i : graph[n]) {
				--in[i]; if (in[i] == 0) q.push(i);
			}
		}

		cout << result << '\n';
	}
}