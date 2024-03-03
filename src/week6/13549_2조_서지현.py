import sys
from collections import deque

n, k = map(int, sys.stdin.readline().split())
queue = deque()
answer = int(1e9)
check = [0 for _ in range(100_010)]
queue.append((n, 0))
queue.append((2 * n, 0))
check[n] = 1
if 2 * n < 100_010:
    check[2 * n] = 1

while queue:
    node, cnt = queue.popleft()
    if node == k:
        answer = min(answer, cnt)
        continue
    if 100_010 > node * 2 > 0 == check[2 * node]:
        check[2 * node] = check[node]
        queue.appendleft((2 * node, cnt))
    if 100_010 > node - 1 >= 0 == check[node - 1]:
        check[node - 1] = check[node] + 1
        queue.append((node - 1, cnt + 1))
    if 100_010 > node + 1 >= 0 == check[node + 1]:
        check[node + 1] = check[node] + 1
        queue.append((node + 1, cnt + 1))

print(answer)