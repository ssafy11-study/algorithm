import sys

n = int(sys.stdin.readline().rstrip())
graph = []

for _ in range(n):
    data = list(map(int, sys.stdin.readline().split()))
    graph.append(data)

white = 0
blue = 0


def recur(x, y, r):
    global white, blue

    color = graph[x][y]
    for i in range(x, x + r):
        for j in range(y, y + r):
            if graph[i][j] != color:
                recur(x, y, r // 2)
                recur(x + (r // 2), y, r // 2)
                recur(x, y + (r // 2), r // 2)
                recur(x + (r // 2), y + (r // 2), r // 2)
                return

    if color == 1:
        blue += 1
    else:
        white += 1


recur(0, 0, n)
print(white)
print(blue)