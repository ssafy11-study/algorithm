#include <iostream>
#include <vector>
using namespace std;

// 부울경_4반_배선영

int N = 0; // 컴퓨터 수
int e = 0; // 연결되어 있는 정보의 수
int visited[101] = { 0 };
int result = 0;
vector<vector<int>> v(101);

void dfs(int start) {
	for (int i = 0; i < v[start].size(); i++) {
		if (visited[v[start][i]] == 0) {
			result += 1;
			visited[v[start][i]] = 1;
			dfs(v[start][i]);
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> N >> e;

	int input1, input2;
	for (int i = 0; i < e; i++) {
		cin >> input1 >> input2;
		v[input1].push_back(input2);
		v[input2].push_back(input1);
	}

	visited[1] = 1;
	dfs(1);
	cout << result << '\n';

	return 0;
}