str_num = input()
arr = [int(num) for num in str_num]
arr = sorted(arr, reverse=True)
for i in arr:
    print(i, end = '')
