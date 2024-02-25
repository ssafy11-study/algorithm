def find_start(input_map):
	n = len(input_map)
	m = len(input_map[0])
	
	for i in range(n):
		for j in range(m):
			if input_map[i][j] == 2:
				input_map[i][j] = -1
				return (j, i, 0)

def BFS(input_map, result_map, my_queue):
	x, y, c = my_queue.pop(0)
	
	result_map[y][x] = c
	
	dx = [1, -1, 0, 0]
	dy = [0, 0, 1, -1]
	
	n = len(input_map)
	m = len(input_map[0])
	
	for i in range(4):
		nx = x + dx[i]
		ny = y + dy[i]
		
		if nx >=0 and nx < m and ny >= 0 and ny < n and input_map[ny][nx] > 0:
			input_map[ny][nx] = -1
			my_queue.append((nx, ny, c + 1))

def clear_map(input_map, result_map):
	n = len(input_map)
	m = len(input_map[0])
	
	for i in range(n):
		for j in range(m):
			if input_map[i][j] == 0:
				result_map[i][j] = 0

n, m = map(int, input().split())

my_map = [list(map(int, input().split())) for i in range(n)]
result = [[-1 for i in range(m)] for i in range(n)]
my_queue = list()

my_queue.append(find_start(my_map))

while len(my_queue) > 0:
	BFS(my_map, result, my_queue)

clear_map(my_map, result)

for row in result:
	for col in row:
		print(col, end=' ')
	print()