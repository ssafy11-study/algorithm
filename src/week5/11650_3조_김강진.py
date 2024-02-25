import sys

N = int(sys.stdin.readline())

arr = []

for i in range(N):
    tmp = list(map(int,input().split()))
    arr.append(tmp)

res_array = sorted(arr)

for i in res_array:
    print(i[0], i[1])