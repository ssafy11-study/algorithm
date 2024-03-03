import sys

n = int(sys.stdin.readline().rstrip())
waiting = list(map(int,sys.stdin.readline().split()))
waiting.sort()

answer = 0
for i in range(n):
  answer += waiting[i] * (n-i)

print(answer)