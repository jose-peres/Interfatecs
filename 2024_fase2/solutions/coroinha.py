L, C, N, CL, CC = map(int, input().split())
s = input()

hor_diff = 0
ver_diff = 0

for c in s:
  match c:
    case 'C':
      ver_diff += 1
    case 'D':
      hor_diff -= 1
    case 'B':
      ver_diff -= 1
    case 'E':
      hor_diff += 1

if CC + hor_diff < 1 or CC + hor_diff > C or CL + ver_diff < 1 or CL + ver_diff > L:
  print("-1 -1")
else:
  print(CL+ver_diff, CC+hor_diff)
