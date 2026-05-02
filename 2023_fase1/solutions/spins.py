from math import isqrt

while True:
  N = int(input())
  if N == 0:
    break
  line = []
  for i in range(1, isqrt(N)+1):
    line.append(str(i*i))
  print(' '.join(line))
