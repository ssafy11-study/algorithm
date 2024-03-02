#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

constexpr int INF = 1'000'000'000;

vector<vector<int>> order = {
	{},
	{ 0, 1, 6 },
	{ 1 },
	{ 2 },
	{ 3 },
	{ 4, 6 },
	{ 5 }
};

string state_char = ".BANANA";

int main() {
	cin.tie(nullptr)->sync_with_stdio(false);
	string s; cin >> s; s = "." + s;
	vector<vector<int>> dp(s.size(), vector<int>(7, INF));
	dp[0][0] = 0;

	for (int i = 1; i < s.size(); ++i) {
		for (int j = 1; j < 7; ++j) {
			int base = s[i] != state_char[j];
			for (int t : order[j]) {
				dp[i][j] = min(dp[i][j], dp[i - 1][t] + base);
			}
		}
	}

	cout << dp.back().back() << '\n';
}