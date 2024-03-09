import sys
sys.setrecursionlimit(10000)

n, m = map(int, input().split())

list = [[] for _ in range(n + 1)]

visited = [False] * int(n + 1)
for _ in range(m):
    a, b = map(int, input().split())
    list[a].append(b)
    list[b].append(a)

for i in list:
    i.sort()

answer = 0

def dfs(start):
    visited[start] = True
    for i in list[start]:
        if not visited[i]:
            dfs(i)
    return 1

for i in range(1, n + 1):

    if visited[i]:
        continue
    else:
        answer += dfs(i)

print(answer)