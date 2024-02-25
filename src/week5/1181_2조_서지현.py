import sys

n = int(sys.stdin.readline().rstrip())
data = []
english = ["a","b","c","d","e","f","g","h","i","j","k",'l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']

for _ in range(n):
  word = sys.stdin.readline().rstrip()
  data.append(word)

NoDuplication = list(set(data))
answer = []

for i in range(len(NoDuplication)):
  [x,y] = [len(NoDuplication[i]),NoDuplication[i]]
  answer.append([x,y])

answer.sort()
answer.sort(key = lambda  answer: (answer[0]))

for i in range(len(NoDuplication)):
  print(answer[i][1])