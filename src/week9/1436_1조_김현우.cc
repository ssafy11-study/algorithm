#include <iostream>

using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	long long N, num = 666;
	cin >> N;
	while (N != 0) {
		long long count = 0, number = num;
		while (number != 0) {
			if (number % 10 == 6) {
				count++;
			}
			else {
				count = 0;
			}
			if (count == 3) {
				break;
			}
			number /= 10;
		}
		if (count == 3) {
			N--;
		}
		if (N != 0) {
			num++;
		}
	}
	cout << num;
}