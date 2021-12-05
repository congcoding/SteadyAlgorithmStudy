import sys

N, M = sys.stdin.readline().split()
N = int(N)
M = int(M)
print(M - N - 1)

for i in range(N + 1, M):
   print(i, end = ' ')
