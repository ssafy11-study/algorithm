#include <iostream>
#include <vector>
#include <array>
#include <string>
#include <algorithm>
using namespace std;

constexpr int MAX_SIZE = 15'000;

int N, M, K;
string S;

array<bool, MAX_SIZE + 1> table;

int main() {
	cin.tie(nullptr)->sync_with_stdio(false);
	int TC; cin >> TC;
	for (int tc = 1; tc <= TC; ++tc) {
		table.fill(false);

		cin >> N >> M >> K;
		cin >> S;

		// M = min(M, N);

		for (int i = 0; i + M <= N; ++i) {
			int h = 0;
			for (int j = i; j < i + M; ++j) {
				if (S[j] - 'a' >= K) goto br;
				h = h * K + (S[j] - 'a');
				if (h > MAX_SIZE) goto br;
			}
			table[h] = true;
		br:;
		}

		for (int i = 0; i <= MAX_SIZE; ++i) {
			if (!table[i]) {
				string s;
				int h = i;
				for (int m = 0; m < M; ++m) {
					s.push_back('a' + h % K);
					h /= K;
				}
				reverse(s.begin(), s.end());
				cout << s << '\n';
				break;
			}
		}
	}

}