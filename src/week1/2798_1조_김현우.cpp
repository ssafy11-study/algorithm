#include <iostream>

using namespace std;
// 김현우
int main(void) {
	long long arr[100] = { 0 };
	long long N, M, sum = 0;
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}
	for (int i = 0; i < N - 2; i++) {
		for (int j = i+1; j < N - 1; j++) {
			for (int k = j + 1; k < N; k++) {
				if (arr[i] + arr[j] + arr[k] <= M && M - (arr[i] + arr[j] + arr[k]) < M - sum) {
					sum = arr[i] + arr[j] + arr[k];
					if (sum == M) {
						cout << sum;
						return 0;
					}
				}
			}
		}
	}
	cout << sum;
}