import sys
import heapq

V, e = map(int, sys.stdin.readline().split())
start = int(sys.stdin.readline().rstrip())

graph = [[] for _ in range(V + 1)]
dist = [int(1e9) for _ in range(V + 1)]
data = []
dist[start] = 0

for _ in range(e):
    u, v, w = map(int, sys.stdin.readline().split())
    graph[u].append([v, w])

heapq.heappush(data, [0, start])

while data:
    d, node = heapq.heappop(data)
    for a, b in graph[node]:
        if dist[a] > dist[node] + b:
            dist[a] = dist[node] + b
            heapq.heappush(data, [dist[a], a])

for i in range(1, V+1):
    if dist[i] == int(1e9):
        print("INF")
    else:
        print(dist[i])