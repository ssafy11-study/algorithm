import sys

n = int(sys.stdin.readline().rstrip())
Map = []

for i in range(n):
  [x,y] = list(map(int, sys.stdin.readline().split()))
  Map.append([x,y])

Map.sort()

for i in range(n):
  print(Map[i][0], Map[i][1])