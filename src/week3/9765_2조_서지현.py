import sys
import collections

k, n = map(int, sys.stdin.readline().split())
data = collections.defaultdict(list)
dic = collections.defaultdict(int)
for i in range(97, 123):
    dic[chr(i)] = 0

for _ in range(k):
    temp = sys.stdin.readline().rstrip()
    data[temp[0]].append(temp)

for i in data:
    data[i].sort()

for _ in range(n):
    command = sys.stdin.readline().rstrip()
    print(data[command][(dic[command] % len(data[command]))])
    dic[command] += 1