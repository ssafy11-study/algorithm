#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
using ll = long long;

constexpr ll INF = 1'000'000'000'000'000LL;

struct MatSize {
	int r, c;

	int operator*(MatSize const& m) {
		return r * c * m.c;
	}
};

int N;
vector<MatSize> mat;
vector<vector<ll>> dp;

// 폐구간 [left, right]
int topDown(int left, int right) {
	if (left == right) return 0;

	auto& res = dp[left][right];
	if (res != INF) return res;

	for (int mid = left; mid < right; ++mid) {
		int l = topDown(left, mid);
		int r = topDown(mid + 1, right);
		MatSize lsize = { mat[left].r, mat[mid].c };
		MatSize rsize = { mat[mid + 1].r, mat[right].c };
		
		res = min(res, (ll)l + r + lsize * rsize);
	}

	return res;
}

int main() {
	cin.tie(nullptr)->sync_with_stdio(false);
	cin >> N;
	mat.assign(N, {});
	dp.assign(N, vector<ll>(N, INF));
	for (int i = 0; i < N; ++i) cin >> mat[i].r >> mat[i].c;
	cout << topDown(0, N - 1) << '\n';
}