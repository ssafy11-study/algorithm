#include <iostream>

using namespace std;

int main(void) {
	cin.tie(NULL);
	cout.tie(NULL);
	int A, B;
	cin >> A >> B;
	for (int i = min(A, B); i >= 1; i--) {
		if (A % i == 0 && B % i == 0) {
			cout << i << '\n';
			break;
		}
	}
	for (int i = max(A, B); ; i++) {
		if (i % A == 0 && i % B == 0) {
			cout << i;
			break;
		}
	}
}