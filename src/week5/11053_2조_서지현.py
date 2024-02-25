import sys

n = int(sys.stdin.readline().rstrip())
data = list(map(int, sys.stdin.readline().split()))
dp = [1 for _ in range(n + 1)]

for i in range(n):
    for j in range(i):
        if data[j] < data[i]:
            dp[i] = max(dp[i], dp[j] + 1)
print(max(dp))