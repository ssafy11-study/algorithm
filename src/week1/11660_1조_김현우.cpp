#include <iostream>

using namespace std;

int dp[1025][1025] = { 0 };

int main(void) {
	cin.tie(NULL);
	cout.tie(NULL);
	int N, M, x1, y1, x2, y2;
	cin >> N >> M;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			cin >> dp[i][j];
			if (i != 0 && j != 0) {
				dp[i][j] = dp[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
			}
			else if (i != 0) {
				dp[i][j] = dp[i][j] + dp[i - 1][j];
			}
			else if (j != 0) {
				dp[i][j] = dp[i][j] + dp[i][j - 1];
			}
		}
	}
	for (int t = 0; t < M; t++) {
		cin >> x1 >> y1 >> x2 >> y2;
		cout << dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1] << "\n";
	}
}