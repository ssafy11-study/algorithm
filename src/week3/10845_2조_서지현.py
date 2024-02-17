import sys
from collections import deque

n = int(sys.stdin.readline().rstrip())
queue = deque()

for _ in range(n):
    data = list(map(str, sys.stdin.readline().split()))
    if data[0] == 'push':
        queue.append(data[1])
    if data[0] == 'front':
        if len(queue) == 0:
            print(-1)
        else:
            print(queue[0])
    if data[0] == 'back':
        if len(queue) == 0:
            print(-1)
        else:
            print(queue[-1])
    if data[0] == 'size':
        print(len(queue))
    if data[0] == 'empty':
        if len(queue) == 0:
            print(1)
        else:
            print(0)
    if data[0] == 'pop':
        if len(queue)==0:
            print(-1)
        else:
            target = queue.popleft()
            print(target)