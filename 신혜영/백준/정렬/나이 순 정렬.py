import sys

input = sys.stdin.readline

N = int(input())
arr = []
for i in range(N):
    arr.append(list(input().split()))
arr.sort(key = lambda x:int(x[0]))

for i in range(len(arr)):
    print(arr[i][0], arr[i][1])
