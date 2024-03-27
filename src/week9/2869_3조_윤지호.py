a, b, v = map(int, input().split())

m, n = divmod(v - a, a - b)

if v < a:
    print(1)
elif n == 0:
    print(m + 1)
else:
    print(m + 2)