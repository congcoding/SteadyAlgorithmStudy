import sys

input = sys.stdin.readline

N, M = map(int, input().split())

name = []
result = {}
for i in range(N + M):
    name.append(input().replace('\n', ''))

for i in name:
    if i in result:
        result[i] += 1
    else: 
        result[i] = 1

name_result = []
for i in result:
    if result[i] == 2:
        name_result.append(i)
name_result.sort()
print(len(name_result))
for name in name_result:
    print(name)
