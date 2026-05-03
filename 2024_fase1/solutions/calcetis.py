V, N = map(int, input().split())
target = 200 - V

freq = [0 for _ in range(201)]
for _ in range(N):
  P = int(input())
  freq[P] += 1

found = False
for i in range(30, 201):
  for j in range(i, 201):
    for k in range(j, 201):
      if freq[i] >= 1+(i==j)+(i==k) and freq[j] >= 1+(j==k) and freq[k] >= 1:
        if i+j+k == target:
          found = True

print("fretegratis" if found else "fretepago")
