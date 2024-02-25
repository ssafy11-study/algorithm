import sys

N = int(sys.stdin.readline())

arr = []
max_n = 0
for i in range(N):
    tmp = input()
    if len(tmp) > max_n:
        max_n = len(tmp)
    arr.append(tmp)
    
# print(max_n)
res = [[] for _ in range(max_n)]

for i in arr:
    if i in res[len(i)-1]:
        continue
    else:
        res[len(i)-1].append(i)

# print(res)

for i in res:
    if len(i) < 1:
        continue
    elif len(i) == 1:
        print(i[0])
    else:
        i.sort()
        for j in i:
            print(j)