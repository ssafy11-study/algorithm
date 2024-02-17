#include <iostream>
#include <vector>
#include <queue>
#define MAX 32001
using namespace std;

int N, M;
vector<int> v[MAX];
int inDegree[MAX] = { 0 };
int result[MAX] = { 0 };

void graph() {
	queue<int> q;

	// 진입 차수 0 찾기
	for (int i = 1; i <= N; i++) {
		if (inDegree[i] == 0) q.push(i);
	}

	for (int i = 1; i <= N; i++) {
		int nNum = q.front();
		q.pop();

		// 진입 차수 감소
		for (int i = 0; i < v[nNum].size(); i++) {
			inDegree[v[nNum][i]]--;
			if (inDegree[v[nNum][i]] == 0) q.push(v[nNum][i]);
		}

		// result에 결과 순서대로 값 넣기
		result[i] = nNum;
	}
}

int main() {
	cin >> N >> M;

	int a, b;
	for (int i = 0; i < M; i++) {
		cin >> a >> b;
		v[a].push_back(b);
		inDegree[b] += 1;
	}

	graph();

	for (int i = 1; i <= N; i++) {
		cout << result[i] << " ";
	}
	cout << '\n';
}