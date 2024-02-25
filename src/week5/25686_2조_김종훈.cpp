#include <iostream>
#include <vector>
using namespace std;

void solve(int s_rng, int e_rng, int s_n, int d) {
	if (s_rng == e_rng) {
		cout << s_n << ' ';
		return;
	}

	int mid = (s_rng + e_rng) / 2;
	solve(s_rng, mid, s_n, 2 * d);
	solve(mid + 1, e_rng, s_n + d, 2 * d);
}

int main() {
	cin.tie(nullptr)->sync_with_stdio(false);
	int N; cin >> N;
	solve(0, N - 1, 1, 1);
}