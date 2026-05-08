import sys

L, C = [int(n) for n in input().split()]
J = int(input())

cartelas = []
for _ in range(J):
  cartelas.append([[int(n) for n in input().split()] for _ in range(L)])

B = int(input())
K = [int(input()) for _ in range(B)]

def find(targetValue, table):
  for i in range(L):
    for j in range(C):
      if table[i][j] == targetValue:
        return (i, j)
  return None

def checkWin(line, col, table):
  acc = 0
  for i in range(L):
    acc += table[i][col]
  if acc == 0:
    return True
  acc = 0
  for j in range(C):
    acc += table[line][j]
  if acc == 0:
    return True
  return False

victory = None
for r in range(len(K)):
  if victory !=  None:
    print(victory[0]+1, victory[1]+1)
    break
  for p in range(len(cartelas)):
    ret = find(K[r], cartelas[p])
    if ret != None:
      i, j = ret
      cartelas[p][i][j] = 0
      if checkWin(i, j, cartelas[p]):
        if victory != None:
          print("EMPATE")
          sys.exit()
        victory = (p, r)

if victory == None:
  print("NADA")
