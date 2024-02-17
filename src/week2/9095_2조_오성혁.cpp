#include <iostream>
#include <vector>

using namespace std;
vector <int> dp(11);

int find(int num) {
	if (dp[num] != 0) {
		return dp[num];
	}
	return find(num-1)+find(num-2)+find(num-3);
}



int main() {
	dp[0] = 0;
	dp[1] = 1;
	dp[2] = 2;
	dp[3] = 4;
	int T;
	cin >> T;
	for (int t = 0; t < T; t++) {
		int num;
		cin >> num;
		cout << find(num) << endl;
	}
	return 0;
}