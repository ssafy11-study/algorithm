import sys
from collections import deque

queue = deque()

n, m = map(int, sys.stdin.readline().split())
graph = []
for _ in range(n):
    data = list(map(str, sys.stdin.readline().rstrip()))
    graph.append(data)

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

check = [[[0 for _ in range(2)] for _ in range(m)] for _ in range(n)]
check[0][0][0] = 1
queue.append((0, 0, 0))


def bfs():
    while queue:
        x, y, jump = queue.popleft()

        if x == n - 1 and y == m - 1:
            return check[x][y][jump]

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < m:
                if graph[nx][ny] == '0' and check[nx][ny][jump] == 0:
                    check[nx][ny][jump] = check[x][y][jump] + 1
                    queue.append((nx, ny, jump))
                if graph[nx][ny] == '1' and jump == 0:
                    check[nx][ny][jump + 1] = check[x][y][jump] + 1
                    queue.append((nx, ny, jump + 1))
    return -1


print(bfs())