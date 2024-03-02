#include <iostream>
#include <algorithm>
using namespace std;

int P[1001];

int main() {
	int N;	cin >> N;
	for (int i = 0; i < N; i++)
		cin >> P[i];

	sort(P, P + N);

	int result = 0;
	for (int i = 0; i < N; i++) {
		int sum = 0;
		for (int j = 0; j <= i; j++) {
			sum += P[j];
		}
		result += sum;
	}

	cout << result;
	
	return 0;
}
