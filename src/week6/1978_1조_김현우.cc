#include<iostream>

using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	int N, sum = 0;
	cin >> N;
	for (int i = 0; i < N; i++) {
		int M;
		cin >> M;
		int sum2 = 0;
		for (int j = 1; j < M; j++) {
			if (M % j == 0) {
				sum2++;
			}
		}
		if (sum2 == 1) {
			sum++;
		}
	}
	cout << sum;
}