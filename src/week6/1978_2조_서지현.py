import sys

n = int(sys.stdin.readline().rstrip())
data = list(map(int, sys.stdin.readline().split()))
target = []

for i in data:
    if i == 1:
        target.append(i)
        continue

    for j in range(2, i):
        if i % j == 0:
            target.append(i)
            break

print(n-len(target))