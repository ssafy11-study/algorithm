import sys

n = int(sys.stdin.readline().rstrip())
r = [0] * (n+3)
g = [0] * (n+3)
b = [0] * (n+3)

data = [[0 for i in range(4)] for _ in range(n+2)]

for i in range(1,n+1):
  r[i],g[i],b[i] = map(int,sys.stdin.readline().split())

for i in range(1,n+1):
  data[i][0] = min(data[i-1][1], data[i-1][2]) + r[i]
  data[i][1] = min(data[i-1][0], data[i-1][2]) + g[i]
  data[i][2] = min(data[i-1][0], data[i-1][1]) + b[i]

print(min(data[n][0], data[n][1], data[n][2]))