N, K = map(int, input().split())

Alist = list()

for i in range(N):
    Alist.append(int(input()))


Alist.sort(reverse=True)
count = 0
for A in Alist:
    if A > K:
        continue
    left = K % A
    temp = K // A
    K = left
    count += temp
    if K <= 0:
        break

print(count)