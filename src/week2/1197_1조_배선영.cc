#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int v, e;
vector<pair<int, pair<int, int>>> graph; // 가중치, 노드1,노드2
int parents[10001] = { 0 };
int price = 0; // 가중치 저장
int cnt = 0;

vector<pair<int, pair<int, int>>> mst; // mst 요소 추가

int checkPnode(int x) { // 부모가 같은지 확인
	if (parents[x] == x) return x;
	else return parents[x] = checkPnode(parents[x]);
}

void unionFun(int a, int b) {
	a = checkPnode(a);
	b = checkPnode(b);
	if (a == b) return;
	parents[b] = a;
}

void checkMST() {
	for (int i = 0; i < e; i++) {
		int node1 = graph[i].second.first;
		int node2 = graph[i].second.second;
		int num = graph[i].first;

		// node1이랑 node2의 부모가 같으면 트리 추가 x
		if (checkPnode(node1) == checkPnode(node2)) continue;

		// 부모 노드 갱신
		unionFun(node1, node2);
		price += num;
		cnt++;
		if (cnt == v) break;
	}
}

int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	cin >> v >> e;

	int a, b, c;
	for (int i = 0; i < e; i++) {
		cin >> a >> b >> c;
		graph.push_back({ c, {a,b} });
	}
	sort(graph.begin(), graph.end()); // 가중치 기준 오름차순 정렬

	for (int i = 1; i <= v; i++) parents[i] = i;

	checkMST();
	cout << price << "\n";
}