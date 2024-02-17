import sys

N = int(sys.stdin.readline())

arr = []

for i in range(N):
    age, name = map(str, input().split())
    age = int(age)
    arr.append((age, name))

arr.sort(key = lambda x: x[0])

for j in arr:
    print(j[0], j[1])