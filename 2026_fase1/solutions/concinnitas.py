L, A = map(int, input().split())

M = [input().split() for _ in range(A)]

found = False

for i in range(A):
  if not found:
    for j in range(L//2):
      if M[i][j] != M[i][L-1-j]:
        found = True
        break

for j in range(L):
  if not found:
    for i in range(A//2):
      if M[i][j] != M[A-1-i][j]:
        found = True
        break

print('CERTAMENTE FALSA' if found else 'PODE SER VERDADEIRA')
