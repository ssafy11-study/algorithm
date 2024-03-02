#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	cin.tie(nullptr)->sync_with_stdio(false);
	cout.setf(ios::fixed);
	cout.precision(6);
	int N, W;
	while (true) {
		cin >> N >> W;
		if (N == 0 && W == 0) break;

		vector<int> values(N);
		for (auto& v : values) cin >> v;

		int max_val = *max_element(values.begin(), values.end());
		int n_area = max_val / W + 1;

		vector<int> heights(n_area);
		for (int v : values) ++heights[v / W];
		int height_max = *max_element(heights.begin(), heights.end());

		vector<int> rate(n_area);
		for (int i = 0; i < n_area; ++i) rate[i] = n_area - i - 1;

		double result = 0.01;
		for (int i = 0; i < n_area; ++i) {
			result += ((double)rate[i] / (n_area - 1)) * ((double)heights[i] / height_max);
		}

		cout << result << '\n';
	}
}