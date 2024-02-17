import sys

n = int(sys.stdin.readline().rstrip())
request = []
for _ in range(n):
    t = int(sys.stdin.readline().rstrip())
    request.append(t)
request.sort()

ch = 1
for ch in range(1,n+1):
    if request[ch-1] + 1 <=ch:
        break
print(ch)