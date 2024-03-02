#include <iostream>
#include <vector>
using namespace std;

int main() {
	cin.tie(nullptr)->sync_with_stdio(false);
	int N; cin >> N;
	vector<int> ns(N); for (auto& n : ns) cin >> n;
	int left = 0, right = N, res = 0;
	while (left <= right) {
		int mid = (left + right) / 2;
		int cnt = 0;
		for (int i = 0; i < N; ++i) {
			if (ns[i] >= mid) ++cnt;
		}
		if (cnt >= mid) {
			res = mid;
			left = mid + 1;
		}
		else {
			right = mid - 1;
		}
	}

	cout << res << '\n';
}