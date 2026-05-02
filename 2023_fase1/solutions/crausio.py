L, C, B = map(int, input().split())
X, Y = map(int, input().split())

R = input()

hits = 0

for c in R:
  if B == 0:
    break
  B -= 1
  if c == 'C':
    if X == 1:
      hits += 1
    else:
      X -= 1
  elif c == 'B':
    if X == L:
      hits += 1
    else:
      X += 1
  elif c == 'E':
    if Y == 1:
      hits += 1
    else:
      Y -= 1
  elif c == 'D':
    if Y == C:
      hits += 1
    else:
      Y += 1

print(X, Y, hits)
