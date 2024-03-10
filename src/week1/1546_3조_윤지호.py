n = int(input())
inputs = list(map(int, input().split()))
m = max(inputs)
sum = 0
for i in inputs:
    sum += i / m * 100
print(sum/n)