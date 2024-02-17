#include <iostream>
#include <vector>

using namespace std;

long long arr[101][100001] = {0};
vector <pair<long long, long long>> arr2 = { {0,0} };

int main(void) {
	int N, K;
	cin >> N >> K;
	long long a, b;
	for (int i = 1; i <= N; i++) {
		cin >> a >> b;
		arr2.push_back(make_pair(a, b));
	}
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= K; j++) {
			if (arr2[i].first <= j) {
				arr[i][j] = max(arr[i - 1][j], arr[i - 1][j - arr2[i].first] + arr2[i].second);
			}
			else {
				arr[i][j] = arr[i - 1][j];
			}
		}
	}
	cout << arr[N][K];
}