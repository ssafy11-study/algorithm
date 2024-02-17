def factorial(n):
    res = 1
    for i in range(1,n+1):
        res = res * i
    return res

n, k = map(int,input().split())

## n! / (k!*(n-k)!)
res = int(factorial(n) / (factorial(k) * factorial(n-k)))

print(res)