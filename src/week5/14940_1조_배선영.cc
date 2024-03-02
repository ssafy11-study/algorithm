#include <iostream>
#include <queue>
#define MAX 1001
using namespace std;
int map[MAX][MAX] = { 0 };
int visited[MAX][MAX] = { 0 };
int N, M;
int startX, startY;
int x[] = { 1, 0, -1, 0 };
int y[] = { 0, 1, 0, -1 };

void bfs() {
	queue<pair<int, int>> q;
	q.push({ startY, startX });
	visited[startY][startX] = 1;

	while (!q.empty()) {
		int cy = q.front().first;
		int cx = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int ny = cy + y[i];
			int nx = cx + x[i];

			if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
			if (visited[ny][nx] != 0 || map[ny][nx] == 0) continue;
			visited[ny][nx] = visited[cy][cx] + 1;
			q.push({ ny, nx });
		}
	}
}
	
int main() {
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> map[i][j];
			if (map[i][j] == 2) {
				startY = i;
				startX = j;
			}
		}
	}

	bfs();

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (map[i][j] == 0) cout << 0 << " ";
			else cout << visited[i][j] - 1 << " ";
		}
		cout << '\n';
	}

	return 0;
}