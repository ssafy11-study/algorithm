#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void) {
	cin.tie(NULL);
	cout.tie(NULL);
	long long T, N;
	vector<long long> arr, arr2;
	cin >> T;
	for (long long i = 0; i < T; i++) {
		cin >> N;
		arr.push_back(N);
		arr2.push_back(N);
	}
	sort(arr.begin(), arr.end());
	arr.erase(unique(arr.begin(), arr.end()),arr.end());
	for (int i = 0; i < arr2.size(); i++) {
		cout << lower_bound(arr.begin(), arr.end(), arr2[i]) - arr.begin() << " ";
	}
}