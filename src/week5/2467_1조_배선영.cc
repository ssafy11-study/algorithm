#include <iostream>
#include <algorithm>
#include <math.h>
#define MAX 100001
using namespace std;

int N;
long long int arr[MAX] = { 0 };
long long int resultA, resultB;

int main() {
	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}

	sort(arr, arr + N);

	int left = 0;
	int right = N - 1;
	resultA = arr[left];
	resultB = arr[right];
	int minResult = abs(arr[left] + arr[right]);

	while (left < right) {
		int temp = arr[left] + arr[right];

		if (minResult > abs(temp)) {
			minResult = abs(temp);
			resultA = arr[left];
			resultB = arr[right];
		}

		if (temp < 0) {
			left++;
		}
		else {
			right--;
		}
	}

	cout << resultA << ' ' << resultB << '\n';
	return 0;
}