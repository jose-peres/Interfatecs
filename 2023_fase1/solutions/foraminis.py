N = int(input())

h0 = 1/(2**(0.5))
h1 = h0
g0 = h1
g1 = -g0

def applyM( vecS ):
  return [
    h0*vecS[0]+h1*vecS[1],
    g0*vecS[0]+g1*vecS[1],
    h0*vecS[2]+h1*vecS[3],
    g0*vecS[2]+g1*vecS[3],
    h0*vecS[4]+h1*vecS[5],
    g0*vecS[4]+g1*vecS[5],
    h0*vecS[6]+h1*vecS[7],
    g0*vecS[6]+g1*vecS[7]
  ]

def modSq( vec ):
  acc = 0.0
  for v in vec:
    acc += v*v
  return acc

for _ in range(N):
  S = [int(x) for x in input().split()]
  ES = modSq(S)
  R = applyM(S)
  LF = [R[0],0,R[2],0,R[4],0,R[6],0]
  ELF = modSq(LF)
  print('INIMIGO' if ES != 0.0 and ELF/ES > 0.5 else '-')
