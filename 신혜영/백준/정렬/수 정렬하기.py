num = int(input())
arr = []
for i in range(num):
    arr.append(int(input()))

arr = sorted(arr)
for i in arr:
    print(i)
