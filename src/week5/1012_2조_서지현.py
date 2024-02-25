import sys
from collections import deque

t = int(sys.stdin.readline().rstrip())
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
            if check[nx][ny] == 1:
                continue
            if graph[nx][ny] == 0:
                continue
            if check[nx][ny] == 0 and graph[nx][ny] == 1:
                queue.append((nx, ny))
                check[nx][ny] = 1


for _ in range(t):
    answer = 0
    m, n, k = map(int, sys.stdin.readline().split())
    graph = [[0 for _ in range(m)] for _ in range(n)]
    check = [[0 for _ in range(m)] for _ in range(n)]
    for _ in range(k):
        a, b = map(int, sys.stdin.readline().split())
        graph[b][a] = 1

    queue = deque()
    for i in range(n):
        for j in range(m):
            if check[i][j] == 0 and graph[i][j] == 1:
                queue.append((i, j))
                check[i][j] = 1
                bfs()
                answer += 1
    print(answer)