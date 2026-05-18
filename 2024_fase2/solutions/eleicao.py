c = int(input())
N = int(input())

stations = [[int(n) for n in input().split()] for _ in range(N)]

matrix = [[0 for _ in range(c+1)] for _ in range(N+1)]

# knapsack problem
for j in range(1, c+1):
  for i, cost, people in stations:
    if cost > j:
      matrix[i][j] = matrix[i-1][j]
    else:
      matrix[i][j] = max(
        matrix[i-1][j],
        people + matrix[i-1][j-cost]
      )

print(matrix[-1][-1])
