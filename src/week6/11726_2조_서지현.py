import sys

n = int(sys.stdin.readline().rstrip())

data = [0] * (n+3)
data[1] = 1
data[2] = 2
data[3] = 3

for i in range(3,n+1):
  data[i] = data[i-1]+data[i-2]

print(data[n]%10007)