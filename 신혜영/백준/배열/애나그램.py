import sys

input = sys.stdin.readline

str1 = list(input().replace('\n', ''))
str2 = list(input().replace('\n', ''))

alpha1 = [_ for _ in range(26)]
alpha2 = [_ for _ in range(26)]

result = 0
for i in range(0, len(str1)):
    alpha1[ord(str1[i]) - 97] += 1
for i in range(0, len(str2)):
    alpha2[ord(str2[i]) - 97] += 1
    
for i in range(len(alpha1)):
    result += abs(alpha1[i] - alpha2[i])

print(result)
