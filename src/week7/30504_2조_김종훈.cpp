#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Info {
	int idx, val, res;
};

int main() {
	cin.tie(nullptr)->sync_with_stdio(false);
	int N; cin >> N;
	vector<Info> angry(N);
	vector<int> money(N);

	for (int i = 0; i < N; ++i) {
		int n; cin >> n;
		angry[i] = { i, n };
	}

	for (int& n : money) cin >> n;

	sort(angry.begin(), angry.end(), [](Info const& a, Info const& b) { return a.val < b.val; });
	sort(money.begin(), money.end());

	for (int i = 0; i < N; ++i) {
		if (money[i] < angry[i].val) {
			cout << "-1\n";
			return 0;
		}
		angry[i].res = money[i];
	}

	sort(angry.begin(), angry.end(), [](Info const& a, Info const& b) { return a.idx < b.idx; });

	for (int i = 0; i < N; ++i) {
		cout << angry[i].res << ' ';
	}
}