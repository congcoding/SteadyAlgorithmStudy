from os import terminal_size
import sys

height_list = []
for i in range(9):
    height_list.append(int(sys.stdin.readline()))

height_sum = sum(height_list)

is_exist = False
for i in range(len(height_list) - 1):
    for j in range(i + 1, len(height_list)):
        if height_sum - (height_list[i] + height_list[j]) == 100:
            height_list[i], height_list[j] = -1, -1
            is_exist = True

        if is_exist: break
            

height_list = sorted(height_list)

for i in height_list:
    if i != -1:
        print(i)
