#include <iostream>
#include <algorithm>
using namespace std;

// 부울경_4반_배선영

int main() {
	int N = 0, K = 0; // 물품의 수, 버틸 수 있는 무게
	int value[101] = { 0 }; // 가치
	int weight[101] = { 0 }; // 무게
	int dp[101][100001] = { 0 };

	cin >> N >> K;

	for (int i = 1; i <= N; i++) cin >> weight[i] >> value[i];

	for (int i = 1; i <= K; i++) { // 무게
		for (int j = 1; j <= N; j++) { // 물건
			if (weight[j] > i) dp[j][i] = dp[j - 1][i]; // 현재 물건의 무게가 기준(i)보다 클 경우
			else {
				dp[j][i] = max(dp[j - 1][i], dp[j - 1][i - weight[j]] + value[j]); // 현재 물건을 넣을 때랑 안 넣을 때 가치 비교
			}
		}
	}

	cout << dp[N][K] << '\n';
	
}
