N, K = map(int, input().split())

total = 0

for _ in range(N):
  C, M = map(int, input().split())
  total += C*K + M

print(f"Relatorio MCE: {total} minutos de esforco total")
