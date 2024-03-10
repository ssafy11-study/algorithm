N, K = map(int, input().split())
inList = [i for i in range(1, N+1)]
cur = -1
results = []

while inList:
    for i in range(K-1):
        num = inList.pop(0)
        inList.append(num)
    results.append(inList.pop(0))
    
print(f"<%s>" % ", ".join(map(str, results)))