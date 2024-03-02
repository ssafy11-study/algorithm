#include <iostream>
#include <math.h>
using namespace std;

int main() {
	long long N;
	long long x[10001] = { 0 };
	long long y[10001] = { 0 };
	long double sum[2] = { 0 };

	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> x[i] >> y[i];
	}

	
	for (int i = 0; i < N - 1; i++) {
		sum[0] += x[i] * y[i + 1];
	}
	sum[0] += x[N - 1] * y[0];

	sum[1] += x[0] * y[N - 1];
	for (int i = N - 1; i > 0; i--) {
		sum[1] += x[i] * y[i - 1];
	}
	cout << fixed;
	cout.precision(1);
	cout << abs(sum[0] - sum[1]) * 0.5 << '\n';
}
