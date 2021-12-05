import sys

input = sys.stdin.readline

N, X = input().split()
arr = list(input().split())

for num in arr:
    if int(num) < int(X):
        print(num, end = ' ')
