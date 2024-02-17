#include <iostream>
#include <vector>
#include <algorithm>

//김현우

using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout << fixed;
	cout.precision(2);
	vector<double> arr;
	double N;
	double M;
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> M;
		arr.push_back(M);
	}
	sort(arr.begin(), arr.end(), greater<double>());
	double max = arr[0];
	double sum = 0;
	for (int i = 0; i < N; i++) {
		arr[i] = arr[i] / max * 100;
		sum += arr[i];
	}
	cout << sum / N;
}