def fibo(num):
    zeros = [1, 0, 1]
    ones = [0, 1, 1]
    
    if num >= 3:
        for i in range(2, num):
            zeros.append(zeros[i-1] + zeros[i])
            ones.append(ones[i-1] + ones[i])
    print(zeros[num], ones[num], sep=" ")

inLst = []
for i in range(int(input())):
    inLst.append(int(input()))
    
for i in inLst:
    fibo(i)