import sys

a,b = map(int,sys.stdin.readline().split())
check = list(map(int,sys.stdin.readline().split()))
check.sort()
data = []

def recur(data):
    if len(data) == b:
        for i in data:
            print(i,end= " ")
        print("")
    else:
        for i in check:
            if i not in data:
                data.append(i)
                recur(data)
                data.pop()

for i in check:
    data.append(i)
    recur(data)
    data = []