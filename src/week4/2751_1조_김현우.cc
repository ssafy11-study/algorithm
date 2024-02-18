#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void) {
	cin.tie(NULL);
	long long N, x;
	cin >> N;
	vector <long long> arr;
	for (long long i = 0; i < N; i++) {
		cin >> x;
		arr.push_back(x);
	}
	sort(arr.begin(), arr.end());
	for (long long i = 0; i < arr.size(); i++) {
		cout << arr[i] << '\n';
	}
}