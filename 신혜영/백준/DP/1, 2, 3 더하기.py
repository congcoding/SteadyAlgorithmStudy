T = int(input())
dp = [0] * 100000
dp[1] = 1
dp[2] = 2
dp[3] = 4
arr = []
for i in range(T):
    num = int(input())
    for j in range(4, num + 1):
        dp[j] = dp[j-3] + dp[j-2] + dp[j-1]
    print(dp[num])
