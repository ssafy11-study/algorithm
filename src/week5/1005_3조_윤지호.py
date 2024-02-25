from collections import deque
import sys
input = sys.stdin.readline

t = int(input())
for i in range(t):
    buildings, rules = list(map(int, input().split()))
    edges = [0] * (buildings + 1)
    all = [[] for i in range(buildings+1)]
    
    times = [0] + list(map(int,input().split()))
    
    for j in range(rules):
        start, end = list(map(int, input().split()))
        edges[end] += 1
        all[start].append(end)
        
    target = int(input())
    
    passedTime = [0 for i in range(buildings+1)]
    
    q = deque([])
    for j in range(1, len(edges)):
        if edges[j] == 0:
            q.append(j)
            edges[j] = -1
            passedTime[j] = times[j]
    
    while q:
        building = q.popleft()
        if building == target:
            break
        
        nextBuildings = all[building]
        
        for n in nextBuildings:
            passedTime[n] = max(passedTime[n],  passedTime[building] + times[n])
            edges[n] -= 1
        
        for n in range(1, len(edges)):
            if edges[n] == 0:
                q.append(n)
                edges[n] -= 1
        
    print(passedTime[target])