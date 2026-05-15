c = int(input())
N = int(input())

stations = []

for _ in range(N):
  _, cost, people = [int(n) for n in input().split()]
  stations.append([cost, people])

matrix = [[0 for _ in range(c+1)] for _ in range(N+1)]

# knapsack problem
for j in range(1, c+1):
  for i in range(1, N+1):
    cost, people = stations[i-1]
    if cost > j:
      matrix[i][j] = matrix[i-1][j]
    else:
      matrix[i][j] = max(
        matrix[i-1][j],
        people + matrix[i-1][j-cost]
      )

print(matrix[-1][-1])
