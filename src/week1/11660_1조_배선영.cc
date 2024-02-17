#include <iostream>
using namespace std;

// 부울경_4반_배선영

int main() {
    ios::sync_with_stdio(false);  
    cin.tie(NULL); 
    
	int N, M;
	int map[1025][1025] = { 0 };
	int sum[1025][1025] = { 0 };

	cin >> N >> M;

	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			cin >> map[i][j];
			sum[i][j] = sum[i][j - 1] + sum[i - 1][j] + map[i][j] - sum[i - 1][j - 1];
		}
	}

	int x1, y1, x2, y2;
	while (M--) {
		cin >> x1 >> y1 >> x2 >> y2;
		cout << sum[x2][y2] - sum[x2][y1 - 1] - sum[x1 - 1][y2] + sum[x1 - 1][y1 - 1] << '\n';
	}
}
