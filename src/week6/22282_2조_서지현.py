import sys

n = int(sys.stdin.readline().rstrip())

citations = [0] * (n + 1)

for _ in range(n):
    t = int(sys.stdin.readline().rstrip())
    if t >= n:
        citations[n] += 1
    else:
        citations[t] += 1

h = 0
cnt = 0

for i in range(n, -1, -1):
    cnt += citations[i]
    if cnt >= i:
        h = i
        break

print(h)