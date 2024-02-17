#include <iostream>
#include <string>
#include <cstring>

using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	int arr[50][50] = {0};
	int N, M, min = 65;
	char c;
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> c;
			if (c == 'W') {
				arr[i][j] = 0;
			}
			else {
				arr[i][j] = 1;
			}
		}
	}
	for (int i = 0; i <= N - 8; i++) {
		for (int j = 0; j <= M - 8; j++) {
			int count = 0;
			for (int k = i; k < i + 8; k++) {
				for (int w = j; w < j + 8; w++) {
					if ((k%2 == w%2 && arr[k][w] == 0) || (k%2 != w%2 && arr[k][w] == 1 )) {
						count++;
					}
				}
			}
			

			if (count > 64 - count) {
				count = 64 - count;
			}
			if (count < min) {
				min = count;
			}
		}
	}
	cout << min;
}