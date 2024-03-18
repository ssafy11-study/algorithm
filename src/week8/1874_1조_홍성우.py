n = int(input())
answers = []
counter = 1
stack = []
flag = True

for i in range(n):
    num = int(input())
    while counter <= num:
        answers.append('+')
        stack.append(counter)
        counter += 1
    if stack[-1] == num:
        answers.append('-')
        stack.pop()
    else:
        flag = False

if flag:
    for answer in answers:
        print(answer)
else:
    print("NO")