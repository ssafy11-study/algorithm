import sys

n = int(sys.stdin.readline().rstrip())
data = []
for _ in range(n):
  t = list(map(int,sys.stdin.readline().split()))
  data.append(t)
data.sort(key=lambda x:(x[1],x[0]))

answer = 1
finish = data[0][1]
for i in range(1,n):
  if data[i][0] >= finish:
    answer+=1
    finish = data[i][1]
print(answer)