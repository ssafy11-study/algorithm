#include <iostream>
#include <algorithm>
#define MAX 1000001
using namespace std;

int main() {
	int dp[MAX] = { 0 };
	int N;
	cin >> N;
	dp[1] = 0;
	dp[2] = 1;
	for (int i = 3; i <= N; i++) {
		dp[i] = dp[i - 1] + 1;
		if(i % 3 == 0) dp[i] = min(dp[i], dp[i / 3] + 1);
		if(i % 2 == 0 ) dp[i] = min(dp[i], dp[i / 2] + 1);
	}

	cout << dp[N] << '\n';

	return 0;
}