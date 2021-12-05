import sys
input = sys.stdin.readline
N = int(input())
alph = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 
'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v' , 'w', 'x', 'y', 'z']
strArr = [input().replace('\n', '').split() for _ in range(N)]
result = []
for str in strArr:
    str1 = str[0]
    str2 = str[1]
    flag = True
    for al in alph:
        if str1.count(al) != str2.count(al):
            flag = False
    result.append(flag)

for r in result:
    if r:
        print('Possible')
    else:
        print('Impossible')

