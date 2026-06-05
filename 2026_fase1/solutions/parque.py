T, N = map(int, input().split())
T *= 60

value = []
weight = []

for _ in range(N):
  input() # ignore
  I, D = map(int, input().split())
  value.append(I)
  weight.append(D)

# knapsack 1D

dp = [0]*(T+1)

for i in range(N):
  for time_cost in range(T, weight[i] -1, -1):
    dp[time_cost] = max(
      dp[time_cost],
      dp[time_cost - weight[i]] + value[i]
    )

print(dp[T])
