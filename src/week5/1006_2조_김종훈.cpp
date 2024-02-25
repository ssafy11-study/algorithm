#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

constexpr int INF = 1'000'000'000;

int N, W;
vector<int> ns[2];
vector<int> up, down, mid;

void solve() {
	for (int i = 1; i <= N; ++i) {
		// up 처리
		up[i] = mid[i - 1] + 1;
		if (ns[0][i - 1] + ns[0][i] <= W) up[i] = min(up[i], down[i - 1] + 1);

		// down 처리
		down[i] = mid[i - 1] + 1;
		if (ns[1][i - 1] + ns[1][i] <= W) down[i] = min(down[i], up[i - 1] + 1);

		// mid 처리
		mid[i] = 1 + min(up[i], down[i]);
		if (ns[0][i] + ns[1][i] <= W) mid[i] = min(mid[i], mid[i - 1] + 1);
		if (ns[0][i - 1] + ns[0][i] <= W && ns[1][i - 1] + ns[1][i] <= W) {
			if (i == 1) mid[i] = min(mid[i], 2);
			else if (i > 1) mid[i] = min(mid[i], 2 + mid[i - 2]);
		}
			
	}
}

int main() {
	cin.tie(nullptr)->sync_with_stdio(false);
	int TC; cin >> TC;
	for (int tc = 0; tc < TC; ++tc) {
		cin >> N >> W;
		
		ns[0].assign(N + 1, INF);
		ns[1].assign(N + 1, INF);

		for (int i = 1; i <= N; ++i) cin >> ns[0][i];
		for (int i = 1; i <= N; ++i) cin >> ns[1][i];

		up.assign(N + 1, 0);
		down.assign(N + 1, 0);
		mid.assign(N + 1, 0);

		solve();
		int res = mid.back();

		if (ns[0][1] + ns[0].back() <= W) {
			swap(ns[0].front(), ns[0].back());

			fill(up.begin(), up.end(), 0);
			fill(down.begin(), down.end(), 0);
			fill(mid.begin(), mid.end(), 0);

			up[0] = 1;
			mid[0] = 1;

			solve();
			res = min(res, down.back());

			swap(ns[0].front(), ns[0].back());
		}

		if (ns[1][1] + ns[1].back() <= W) {
			swap(ns[1].front(), ns[1].back());

			fill(up.begin(), up.end(), 0);
			fill(down.begin(), down.end(), 0);
			fill(mid.begin(), mid.end(), 0);

			down[0] = 1;
			mid[0] = 1;

			solve();
			res = min(res, up.back());

			swap(ns[1].front(), ns[1].back());
		}

		if (ns[0][1] + ns[0].back() <= W && ns[1][1] + ns[1].back() <= W) {
			swap(ns[0].front(), ns[0].back());
			swap(ns[1].front(), ns[1].back());

			fill(up.begin(), up.end(), 0);
			fill(down.begin(), down.end(), 0);
			fill(mid.begin(), mid.end(), 0);

			up[0] = 1;
			down[0] = 1;
			mid[0] = (ns[0].front() + ns[1].front() <= W ? 1 : 2);

			solve();
			res = min(res, mid[N - 1]);

			swap(ns[0].front(), ns[0].back());
			swap(ns[1].front(), ns[1].back());
		}

		cout << res << '\n';
	}
}