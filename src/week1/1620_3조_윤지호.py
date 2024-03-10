import sys
input = sys.stdin.readline

N, M = map(int, input().strip().split())
pList = {}
kList = {}
for i in range(N):
    pName = input().strip()
    pList[str(i+1)] = pName
    kList[pName] = str(i+1)
for _ in range(M):
    q = input().strip()
    if q in pList:
        print(pList[q])
    else:
        print(kList[q])

