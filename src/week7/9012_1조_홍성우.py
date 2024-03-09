n = int(input())
answer = []
for _ in range(n):
    leftParenthesis = 0
    string = input()
    for letter in string:
        if letter == "(":
            leftParenthesis += 1
        elif letter == ")":
            leftParenthesis -= 1
        if leftParenthesis < 0:
            answer.append("NO")
            break
    if leftParenthesis > 0:
        answer.append("NO")
    elif leftParenthesis == 0:
        answer.append("YES")
for word in answer:
    print(word)