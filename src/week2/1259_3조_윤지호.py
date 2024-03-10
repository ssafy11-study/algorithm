inputs = []
while True:
    i = int(input())
    if(i == 0): break
    inputs.append(str(i))

for n in inputs:
    left = n[:len(n)//2]
    right = n[(len(n)//2 + len(n)%2):]
    if left == right[::-1]: print("yes")
    else: print("no")