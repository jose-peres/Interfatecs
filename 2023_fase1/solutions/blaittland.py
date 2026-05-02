def solve():
  N = int(input().strip())
  s = input().strip()

  reads = 0

  for i in range(N):
    moves_left = 0
    for j in range(i+1, N):
      if s[i] > s[j]:
        moves_left += 1

    if moves_left > 5:
      print('A Database Systems student read a book.')
      return

    reads += moves_left

  print(reads)


if __name__ == "__main__":
  solve()
