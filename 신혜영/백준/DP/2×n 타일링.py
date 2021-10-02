num = int(input())
dp = [0] * (num + 1)
dp[0] = 1
dp[1] = 1

for i in range(2, num + 1):
    dp[i] = dp[i-2] + dp[i-1]
    
print(dp[num]%10007)
