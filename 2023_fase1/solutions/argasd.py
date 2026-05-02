NEmpr, Q = [int(x) for x in input().split()]
Ndias = int(input())

acc = [[0 for _ in range(NEmpr+1)] for _ in range(NEmpr+1)]

for day in range(Ndias):
  input() # ignored
  for _ in range(NEmpr*NEmpr - NEmpr):
    Empr1, Empr2, amount = [int(x) for x in input().split()]
    acc[Empr1][Empr2] += amount

  print('Final dia', day+1)

  traded = False
  for i in range(1,NEmpr+1):
    for j in range(i+1,NEmpr+1):
      if acc[i][j] >= Q and acc[j][i] >= Q:
        traded = True
        print(f"  Trocas entre {i}({acc[i][j]//Q}v) e {j}({acc[j][i]//Q}v)")
        acc[i][j] %= Q
        acc[j][i] %= Q
  if not traded:
    print("  Sem Trocas")
