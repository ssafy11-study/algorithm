#include <iostream>
using namespace std;

int main() {
	int N;
	int dp[101] = { 0 };
	cin >> N;

	dp[0] = 0;
	dp[1] = 1;
	dp[2] = 2;
	dp[3] = 4;

	for (int i = 0; i < N; i++) {
		int M; cin >> M;
		for (int j = 4; j <= M; j++) dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
		cout << dp[M] << '\n';
	}
	return 0;
}