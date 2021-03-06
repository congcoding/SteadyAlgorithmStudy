import sys

n = sys.stdin.readline()
a = {'0':0, '1':0, '2':0, '3':0, '4':0, '5':0, '6':0, '7':0, '8':0}
for i in range(len(n)):
    # 조건: 6, 9는 뒤집어서 해당 숫자로 사용가능
    if n[i] in ['6', '9']:
        a['6'] += 1
    else:
        a[n[i]] += 1
# 짝수면, 6, 9 한 세트 안에서만 사용했다는 뜻
if a['6'] % 2 == 0:
    a['6'] = a['6'] // 2
# 홀수면, 6, 9 //2 한 상태에서 한 세트 더 사용해야함
else:
    a['6'] = a['6'] // 2 + 1
# max를 하는 이유: 어차피 0~9까지 한 세트에 포함되기 때문에 가장 큰 값이 세트의 개수라고 볼 수 있다.
print(max(a.values()))

