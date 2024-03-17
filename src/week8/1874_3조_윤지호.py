n = int(input())

# 만들 수열
inputs = [0] # 4, 3, 6, 8,7, 5, 2, 1
for i in range(n):
    inputs.append(int(input()))

st = list()     # 과정에 사용하는 스택
result = list() # + -
num = 1     # 현재 사용 중인 수
isImpossible = True
for i in range(1, n+1):     # 결과 배열의 순서
    target = inputs[i]      # 4

    # 찾아서 POP
    if target >= num:
        while target >= num:
            st.append(num)
            result.append("+")
            num += 1
        result.append("-")
        st.pop(-1)
    else:       # target < num
        topNum = st.pop(-1)
        if topNum > target:
            print("NO")
            isImpossible = False
            break
        else:
            result.append("-")
if isImpossible:
    print("\n".join(result))