cnt = int(input())
min_list = list(map(int, input().split()))
min_list = sorted(min_list)
min = 0
for i in range(len(min_list)):
    for j in range(i + 1):
        min += min_list[j]
print(min)
