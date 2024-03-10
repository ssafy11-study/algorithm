import sys
open = sys.stdin.readline

n = int(input())
inputs = list(map(int, input().split()))
inputs.sort()
sums = list()
for i in range(n):
    sums.append(sum(inputs[0:i+1]))
print(sum(sums))