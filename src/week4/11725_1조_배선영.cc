#include <iostream>
#include <vector>
#define MAX 100001
using namespace std;

int N;
vector<int> v[MAX];
int visited[MAX] = { 0 };
int result[MAX] = { 0 };

void dfs(int cur) {
	visited[cur] = 1;
	for (int i = 0; i < v[cur].size(); i++) {
		if (visited[v[cur][i]] == 1) continue;
		visited[v[cur][i]] = 1;
		result[v[cur][i]] = cur;
		dfs(v[cur][i]);
	}
}

int main() {
	cin >> N;

	int a, b;
	for (int i = 1; i < N; i++) {
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}

	dfs(1);
	for (int i = 2; i <= N; i++) {
		cout << result[i] << '\n';
	}
}
