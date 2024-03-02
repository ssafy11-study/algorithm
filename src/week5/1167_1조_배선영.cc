#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int v;
vector<pair<int, int>> tree[100001];
int visited[100001] = { 0 };
int maxLen = -1;
int maxIdx = 0;

void dfs(int startNode, int sumLen) {
	visited[startNode] = 1;

	for (int i = 0; i < tree[startNode].size(); i++) {
		if (visited[tree[startNode][i].first] != 1) {
			dfs(tree[startNode][i].first, sumLen + tree[startNode][i].second);
		}
	}

	if (maxLen < sumLen) {
		maxLen = sumLen;
		maxIdx = startNode;
	}
}

int main() {
	cin >> v;

	int c, n, m;
	for (int i = 0; i < v; i++) {
		cin >> c;
		while (1) {
			cin >> n;
			if (n != -1) {
				cin >> m;
				tree[c].push_back({ n, m });
			}
			else break;
		}
	}

	dfs(1, 0);
	for (int i = 1; i <= v; i++) {
		visited[i] = 0;
	}
	maxLen = -1;
	dfs(maxIdx, 0);
	cout << maxLen << '\n';
}