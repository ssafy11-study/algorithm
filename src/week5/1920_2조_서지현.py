import sys
n = int(sys.stdin.readline().rstrip())
A = list(map(int, sys.stdin.readline().split()))
A.sort()

m = int(sys.stdin.readline().rstrip())
B = list(map(int, sys.stdin.readline().split()))

def binary_search(A,target,start,end):
  while(start<=end):
    mid = (start+end)//2
    if A[mid] == target:
      return mid
    elif A[mid] > target:
      end = mid-1
    else:
      start = mid+1
  return None

for i in B:
  result = binary_search(A,i,0,n-1)
  if result ==None:
    print(0)
  else:
    print(1)