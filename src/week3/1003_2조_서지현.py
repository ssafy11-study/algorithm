import sys

n = int(sys.stdin.readline().rstrip())

for _ in range(n):
    t = int(sys.stdin.readline().rstrip())
    dp_zero = [0] * (t + 3)
    dp_one = [0] * (t + 3)
    dp_one[0] = 0
    dp_zero[0] = 1
    dp_one[1] = 1
    dp_zero[1] = 0
    dp_one[2] = 1
    dp_zero[2] = 1

    if t < 3:
        print(dp_zero[t], dp_one[t])
        continue

    for i in range(3, t + 1):
        dp_one[i] = dp_one[i - 1] + dp_one[i - 2]
        dp_zero[i] = dp_zero[i - 1] + dp_zero[i - 2]
    print(dp_zero[t], dp_one[t])