import sys

n = int(sys.stdin.readline().rstrip())
data = []

for i in range(n):
  x,y = sys.stdin.readline().split()
  x = int(x)
  data.append([x,y])

data.sort(key = lambda x : x[0])

for i in range(n):
  print(data[i][0], data[i][1])