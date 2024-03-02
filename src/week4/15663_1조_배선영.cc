#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N, M;
vector<int> v;
int result[101] = { 0 };
int visited[101] = { 0 };
// 1 7 7 9


// 중복 제거
void output(int cnt) {
	if (cnt == M) {
		for (int i = 0; i < M; i++) {
			cout << result[i] << ' ';
		}
		cout << '\n';
	}

	int last = 0;
	for (int i = 0; i < v.size(); i++) {
		if (visited[i] == 1 || last == v[i]) continue;
		result[cnt] = v[i];
		last = v[i];
		visited[i] = 1;
		output(cnt + 1);
		visited[i] = 0;
	}
}

int main() {
	cin >> N >> M;

	int tmp;
	for (int i = 0; i < N; i++) {
		cin >> tmp;
		v.push_back(tmp);
	}
	sort(v.begin(), v.end());
	output(0);
    return 0;
}