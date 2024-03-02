#include <iostream>
#include <algorithm>
#define MAX 501
using namespace std;

int N;
int map[MAX][MAX] = { 0 };
int dp[MAX][MAX] = { 0 };

int main() {
	cin >> N;

	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= i; j++) {
			cin >> map[i][j];
		}
	}

	dp[1][1] = map[1][1];

	for (int i = 2; i <= N; i++) {
		for (int j = 1; j <= i; j++) {
			dp[i][j] = max(dp[i][j], max(dp[i - 1][j - 1] + map[i][j], dp[i - 1][j] + map[i][j]));
		}
	}

	int maxResult = -1;
	for (int i = 1; i <= N; i++) {
		maxResult = max(maxResult, dp[N][i]);
	}

	cout << maxResult << '\n';
    return 0;
}