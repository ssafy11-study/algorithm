import sys

n = int(sys.stdin.readline().rstrip())
s = set()

for _ in range(n):
    command = list(map(str, sys.stdin.readline().split()))
    if len(command) == 1:
        if command[0] == 'all':
            s = set(i for i in range(1, 21))
        else:
            s = set()
    else:
        if command[0] == "add":
            s.add(int(command[1]))
        elif command[0] == "remove":
            s.discard(int(command[1]))
        elif command[0] == "check":
            print(1 if int(command[1]) in s else 0)
        elif command[0] == "toggle":
            if int(command[1]) in s:
                s.discard(int(command[1]))
            else:
                s.add(int(command[1]))