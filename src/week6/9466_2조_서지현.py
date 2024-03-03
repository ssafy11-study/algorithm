import sys
import collections
sys.setrecursionlimit(10**6)

T = int(sys.stdin.readline().rstrip())
for _ in range(T):
    n = int(sys.stdin.readline().rstrip())
    data = list(map(int, sys.stdin.readline().split()))
    check = [0 for _ in range(n + 1)]
    teamMember = 0


    def dfs(node, origin):
        global teamMember
        check[node] = 1
        dic[node] += 1
        team.append(node)
        next = data[node - 1]

        if check[next] == 1:
            team.append(next)
            dic[next] += 1
            if next in team:
                temp = 0
                flag = 0
                for i in team:
                    if flag == 1:
                        temp += 1
                    if dic[i] == 2:
                        flag = 1
                teamMember += temp
        else:
            dfs(next, origin)


    for i in range(1, n + 1):
        if check[i] == 0:
            team = []
            dic = collections.defaultdict(int)
            dfs(i, i)

    print(n - teamMember)