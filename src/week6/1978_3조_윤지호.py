def isPrime(num):
    if num == 1: return False
    elif num == 2: return True
    for i in range(2, num):
        if num % i == 0: return False
    return True


n = int(input())
count = 0
inputs = list(map(int, input().split()))
for i in inputs:
    if isPrime(i): count +=1
print(count)