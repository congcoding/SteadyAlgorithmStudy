import sys
input = sys.stdin.readline

N = int(input())
n_list = list(map(int, input().split()))


M = int(input())
m_list = list(map(int, input().split()))

result = {}
for n in n_list:
    if n in result:
        result[n] += 1
    else:
        result[n] = 1

print(' '.join(str(result[m]) if m in result else '0' for m in m_list))
