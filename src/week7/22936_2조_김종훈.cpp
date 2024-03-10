#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Rng {
	int s, e;
};

int N, M;
vector<int> mem;
vector<Rng> rngs;

int cut(Rng const& r, int bias) {
	int res = 0;
	for (int i = 0; i < N; ++i) {
		int left = bias + i * 7, right = left + 6;
		if (left > r.e || right < r.s) continue;
		++res;
	}
	return res;
}

int main() {
	cin.tie(nullptr)->sync_with_stdio(false);
	cin >> N >> M;
	int max_pos = 0;
	rngs.assign(M, {});

	for (Rng& r : rngs) {
		cin >> r.s >> r.e;
		--r.s; --r.e;
		max_pos = max(max_pos, r.e);
	}

	mem.assign(max(7 * N + 2, max_pos + 2), 0);

	for (Rng& r : rngs) {
		++mem[r.s];
		--mem[r.e + 1];
	}

	for (int i = 1; i < mem.size(); ++i) mem[i] += mem[i - 1];

	int area = 0;
	for (int i = 0; i < 7 * N; ++i) area += mem[i];

	int max_idx = 0, max_area = area;
	for (int i = 1; i + 7 * N <= mem.size(); ++i) {
		area -= mem[i - 1];
		area += mem[i + 7 * N - 1];

		if (area > max_area) {
			max_idx = i;
			max_area = area;
		}
	}

	int res = 0;
	for (Rng& r : rngs) {
		res += cut(r, max_idx);
	}

	cout << res << '\n';
}