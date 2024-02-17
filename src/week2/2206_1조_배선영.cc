#include <iostream>
#include <queue>
#include <algorithm>
#define MAX 1001
using namespace std;

int N, M;
int map[MAX][MAX] = { 0 };
int x[] = { 1, 0, -1, 0 };
int y[] = { 0, -1, 0, 1 };
int visited[MAX][MAX][2] = { 0 };

//반례
//6 5
//00000
//11110
//00000
//01111
//01111
//00010


int bfs() {
	queue<pair<pair<int, int>, pair<int, int>>> q;
	q.push({ { 0, 0 }, {0, 0} });
	visited[0][0][0] = 1;

	while (!q.empty()) {
		int cy = q.front().first.first;
		int cx = q.front().first.second;
		int oneCheck = q.front().second.first; // cy, cx까지 오는데 벽을 부수고 이동했는지
		int result = q.front().second.second;

		q.pop();

		if (cy == N - 1 && cx == M - 1) {
			return result + 1;
		}

		for (int i = 0; i < 4; i++) {
			int ny = cy + y[i];
			int nx = cx + x[i];

			if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;

			if (map[ny][nx] == 1 && oneCheck == 0) {
				q.push({ {ny, nx} , {oneCheck + 1, result + 1} });
				visited[ny][nx][oneCheck+ 1] = 1;
			}
			else if (map[ny][nx] == 0 && visited[ny][nx][oneCheck] == 0) {
				q.push({ {ny, nx} , {oneCheck, result + 1} });
				visited[ny][nx][oneCheck] = 1;
			}
		}
	}
	return -1;
}

int main() {
	cin >> N >> M;

	string tmp;
	for (int i = 0; i < N; i++) {
		cin >> tmp;
		for (int j = 0; j < M; j++) {
			map[i][j] = tmp[j] - '0';
		}
	}

	cout << bfs() << '\n';
	return 0;
}
