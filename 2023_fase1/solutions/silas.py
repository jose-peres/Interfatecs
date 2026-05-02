from collections import deque

P = int(input())
X, Y = [int(x) for x in input().split()]

M = []
for _ in range(X):
  M.append(input().split())

queue = deque()

for i in range(X):
  for j in range(Y):
    if M[i][j] == 'S':
      queue.append((i,j))
      M[i][j] = 0

found = False
while queue:
  i, j = queue.popleft()
  dist = M[i][j]

  if i > 0:
    val = M[i-1][j]
    if val == 'K':
      print(dist+1)
      found = True
      break
    if isinstance(val, str) and (val.isdigit() and int(val) <= P) or val == '.':
      M[i-1][j] = dist+1
      queue.append((i-1,j))

  if i < X-1:
    val = M[i+1][j]
    if val == 'K':
      print(dist+1)
      found = True
      break
    if isinstance(val, str) and (val.isdigit() and int(val) <= P) or val == '.':
      M[i+1][j] = dist+1
      queue.append((i+1,j))

  if j > 0:
    val = M[i][j-1]
    if val == 'K':
      print(dist+1)
      found = True
      break
    if isinstance(val, str) and (val.isdigit() and int(val) <= P) or val == '.':
      M[i][j-1] = dist+1
      queue.append((i,j-1))

  if j < Y-1:
    val = M[i][j+1]
    if val == 'K':
      print(dist+1)
      found = True
      break
    if isinstance(val, str) and (val.isdigit() and int(val) <= P) or val == '.':
      M[i][j+1] = dist+1
      queue.append((i,j+1))

if not found:
  print('N')
