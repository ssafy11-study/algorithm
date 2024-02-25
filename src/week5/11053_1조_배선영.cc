#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int N;
	int arr[1001] = { 0 };
	int dp[1001] = { 0 };
	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> arr[i];
		dp[i] = 1;
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < i; j++) {
			if (arr[i] > arr[j] && dp[i] <= dp[j]) dp[i] += 1;
		}
	}

	int result = -1;
	for (int i = 0; i < N; i++) result = max(result, dp[i]);
	cout << result << '\n';
}