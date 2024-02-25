import sys
from collections import deque

n, m = map(int, sys.stdin.readline().split())

graph = []
for _ in range(n):
    data = list(map(int, sys.stdin.readline().split()))
    graph.append(data)

queue = deque()
check = [[0 for _ in range(m)] for _ in range(n)]
for i in range(n):
    for j in range(m):
        if graph[i][j] == 2:
            queue.append((i, j))
            graph[i][j] = 0
            check[i][j] = 1

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]


def bfs():
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue
            if graph[nx][ny] == 0:
                continue
            if graph[nx][ny] == 1 and check[nx][ny] == 0:
                graph[nx][ny] = graph[x][y] + 1
                check[nx][ny] = 1
                queue.append((nx, ny))



bfs()
for i in range(n):
    for j in range(m):
        if check[i][j] == 0 and graph[i][j] == 1:
            graph[i][j] = -1

for data in graph:
    for i in data:
        print(i, end=" ")
    print()