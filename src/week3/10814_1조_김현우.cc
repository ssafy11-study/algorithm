#include <iostream>
#include <tuple>
#include <vector>
#include <algorithm>

using namespace std;

int main(void) {
	cin.tie(NULL);
	cout.tie(NULL);
	int T, N;
	string S;
	vector<tuple<int, int, string>> arr;
	cin >> T;
	for (int i = 0; i < T; i++) {
		cin >> N >> S;
		arr.push_back({ N,i,S });
	}
	sort(arr.begin(), arr.end());
	for (int i = 0; i < arr.size(); i++) {
		cout << get<0>(arr[i]) << " " << get<2>(arr[i]) << '\n';
	}
}