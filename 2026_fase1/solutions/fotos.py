N, R = map(int, input().split())
R *= 100

services = []

total_length = 0
total_value = 0
for _ in range(N):
  desc, q, v = input().split()
  A, B = map(int, desc.split('x'))
  q, v = int(q), int(v)
  l = A if B == 10 else B
  services.append([l, q, v])
  total_length += l*q
  total_value += v*q

if total_length <= R:
  print('COMPLETO', total_value)
else:
  dp = [0]*(R+1)

  for length, quantity, value in services:
    group = 1

    while quantity > 0:
      copies = min(group, quantity)
      group_length = length*copies
      group_value = value*copies

      for available in range(R, group_length-1, -1):
        dp[available] = max(
          dp[available],
          dp[available-group_length] + group_value
        )

      quantity -= copies
      group *= 2

  print('PARCIAL', dp[R])
