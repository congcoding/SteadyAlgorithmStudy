import sys

input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
x = int(input())

cnt = 0
arr.sort()

left, right = 0, n - 1

while left < right:
    tmp = arr[left] + arr[right]
    if tmp == x: cnt += 1
      
    # x가 더 크면 left를 움직임
    if tmp < x:
        left += 1
        continue
    # 아니면 right를 움직여 범위를 줄여줌
    right -= 1

print(cnt)
