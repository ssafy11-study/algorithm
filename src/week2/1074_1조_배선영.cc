#include <iostream>
using namespace std;
int N, r, c;
int result = 0;
int output = 0;

// 1 2
// 3 4

void checkMap(int n, int x, int y) {
	if (x == c && y == r) {
		output = result;
	}

	if (r >= y && c >= x && r < y + n && c < x + n) { // 범위 안에 r,c가 존재하면

		// 1
		checkMap(n / 2, x, y);

		// 2
		checkMap(n / 2, x + n / 2, y);

		// 3
		checkMap(n / 2, x, y + n / 2);

		// 4
		checkMap(n / 2, x + n / 2, y + n / 2);
	}
	else {
		result += n * n;
	}
}

int main() {
	cin >> N >> r >> c;
	
	checkMap((1<<N)*(1<<N), 0, 0);

	cout << output << '\n';
}
