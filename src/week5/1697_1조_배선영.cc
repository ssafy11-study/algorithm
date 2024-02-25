#include <iostream>
#include <queue>
using namespace std;

int N, K;
int visited[100001] = { 0 };

int bfs() {
	queue<pair<int, int>> q;
	q.push({N, 0});
	visited[N] = 1;

	while (!q.empty()) {
		int cnum = q.front().first;
		int count = q.front().second;
		q.pop();

		int a = cnum - 1;
		int b = cnum + 1;
		int c = cnum * 2;
		
		if (a == K || b == K || c == K) {
			return count + 1;
		}

		if (a >= 0 && visited[a] == 0) {
			q.push({ a, count + 1 });
			visited[a] = 1;
		}
		if (b <= 100000 && visited[b] == 0) {
			q.push({ b, count + 1 });
			visited[b] = 1;
		}
		if (c <= 100000 && visited[c] == 0) {
			q.push({ c, count + 1 });
			visited[c] = 1;
		}
	}
}

int main() {
	cin >> N >> K;
	if (N == K) cout << 0 << '\n';
	else cout << bfs() << '\n';
}