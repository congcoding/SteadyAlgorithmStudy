cnt = int(input())
score = []
for i in range(cnt):
    score.append(int(input()))

dp = []
dp.append(score[0])
for i in range(1, 3):
    if i == 1:
        dp.append(max(dp[i - 1] + score[i], score[i]))
        continue
    dp.append(max(dp[i - 2] + score[i], score[i - 1] + score[i]))

for i in range(3, cnt):
    dp.append(max(score[i] + score[i - 1] + dp[i - 3], score[i] + dp[i - 2]))

print(dp[-1])
