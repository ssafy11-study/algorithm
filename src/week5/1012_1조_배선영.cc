#include <iostream>
#include <queue>
#define MAX 51
using namespace std;

int N, M, T, K;
int map[MAX][MAX] = { 0 };
int visited[MAX][MAX] = { 0 };

int result = 0;
int x[] = { 1, 0, -1, 0 };
int y[] = { 0, 1, 0, -1 };

void init() {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			map[i][j] = 0;
			visited[i][j] = 0;
		}
	}
	result = 0;
}

void bfs(int startY, int startX) {
	queue<pair<int, int>> q;
	q.push({ startY, startX });

	while (!q.empty()) {
		int cy = q.front().first;
		int cx = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int ny = cy + y[i];
			int nx = cx + x[i];

			if (ny < 0 || nx < 0 || ny >= N || nx >= M || visited[ny][nx] == 1) continue;
			if (map[ny][nx] == 0) continue;
			visited[ny][nx] = 1;
			q.push({ ny, nx });
		}

	}
}

int main() {
	cin >> T;

	for (int t = 0; t < T; t++) {
		cin >> M >> N >> K;

		int a, b;
		for (int i = 0; i < K; i++) {
			cin >> a >> b;
			map[b][a] = 1;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && visited[i][j] == 0) {
					result++;
					bfs(i, j);
				}
			}
		}

		cout << result << '\n';
		init();
	}
	
}