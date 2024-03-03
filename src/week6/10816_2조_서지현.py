import sys
from collections import Counter

n = int(sys.stdin.readline().rstrip())
card = list(map(int,sys.stdin.readline().split()))

m = int(sys.stdin.readline().rstrip())
sang = list(map(int,sys.stdin.readline().split()))
t = Counter(card)

for i in sang:
  if i in t:
    print(t[i])
  else:
    print(0)