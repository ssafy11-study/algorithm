import sys

n = int(sys.stdin.readline().rstrip())
data = list(map(int, sys.stdin.readline().split()))
left = 0
right = n - 1

one = data[left]
two = data[right]
answer = int(1e9) * int(1e9)

while True:
    if left == right:
        break
    if abs(data[left] + data[right]) < answer:
        one = data[left]
        two = data[right]
        answer = abs(data[left] + data[right])

    if data[left] + data[right] < 0:
        left += 1
    else:
        right -= 1
print(one, two)