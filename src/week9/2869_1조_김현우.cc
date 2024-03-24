#include <iostream>

using namespace std;

int main(void) {
	int A, B, V;
	cin >> A >> B >> V;
	V = V - A;
	if (V % (A - B) > 0) {
		V = V / (A - B);
		cout << V + 2;
	}
	else {
		V = V / (A - B);
		cout << V + 1;
	}
}