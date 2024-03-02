import math

while(True):
    test_case = list(map(int,input().split()))
    if test_case.count(0) == 3:
        break
    test_case.sort()
    if test_case[2] == math.sqrt(test_case[0]**2 + test_case[1]**2):
        print("right")
    else:
        print("wrong")