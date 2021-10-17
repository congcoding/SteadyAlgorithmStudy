import sys

input = sys.stdin.readline
N = int(input())
arr = []
for i in range(N):
    arr.append(list(map(int, input().split())))

arr.sort(key = lambda x: (x[1], x[0]))
cnt = 1
end = arr[0][1]
for i in range(1, len(arr)):
    if end <= arr[i][0]:
        end = arr[i][1]
        cnt += 1

print(cnt)
