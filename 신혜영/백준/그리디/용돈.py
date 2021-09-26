
N, K = map(int, input().split())
money_list = []
rest = N
for i in range(N):
    money = input()
    money_list.append(int(money))

cnt = 0
for i in range(len(money_list) - 1, 0, -1):
    if K >= money_list[i]:
        cnt += K // money_list[i]
        K %= money_list[i]

print(cnt)
