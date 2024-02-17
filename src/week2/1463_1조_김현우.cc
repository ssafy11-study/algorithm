#include <iostream>

using namespace std;

int dp[1000002] = { 0 };

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int N;
	cin >> N;
	for (int i = N; i > 0; i--) {
		if (i % 3 == 0 && (dp[i / 3] == 0 || dp[i / 3] > dp[i] + 1)) {
			dp[i / 3] = dp[i] + 1;
		}
		if (i % 2 == 0 && (dp[i / 2] == 0 || dp[i / 2] > dp[i] + 1)) {
			dp[i / 2] = dp[i] + 1;
		}
		if (i - 1 >= 1 && (dp[i - 1] == 0 || dp[i - 1] > dp[i] + 1)) {
			dp[i - 1] = dp[i] + 1;
		}
	}
	cout << dp[1];
}