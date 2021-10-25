import sys

input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))

set_arr = sorted(list(set(arr)))
dict = {set_arr[i] : i for i in range(len(set_arr))}

print(dict)

for i in arr:
    print(dict[i], end = ' ')
