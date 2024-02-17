import sys

n, r, c = map(int, sys.stdin.readline().split())


def recur(n, r, c):
    if n == 0:
        return 0
    half = 2 ** (n - 1)
    if r < half and c < half:
        return recur(n - 1, r, c)
    if r < half <= c:
        return half * half + recur(n - 1, r, c - half)
    if r >= half > c:
        return 2 * half * half + recur(n - 1, r - half, c)
    return 3 * half * half + recur(n - 1, r - half, c - half)


print(recur(n, r, c))