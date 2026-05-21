import sys

COMPLEMENT = {
  'A': 'T',
  'T': 'A',
  'C': 'G',
  'G': 'C',
}

def longest_site(dna):
  n = len(dna)
  radii = [0] * n
  left = 0
  right = -1
  best_start = -1
  best_len = 0

  for center in range(n):
    if center > right:
      radius = 0
    else:
      mirror = left + right - center + 1
      radius = min(radii[mirror], right - center + 1)

    while (
      center - radius - 1 >= 0
      and center + radius < n
      and dna[center - radius - 1] == COMPLEMENT[dna[center + radius]]
    ):
      radius += 1

    radii[center] = radius

    if center + radius - 1 > right:
      left = center - radius
      right = center + radius - 1

    length = 2 * radius
    if length >= 4 and length > best_len:
      best_start = center - radius
      best_len = length

  if best_len == 0:
    return None

  return best_start + 1, best_len

for line in sys.stdin:
  dna = line.strip()
  answer = longest_site(dna)
  if answer is None:
    print('false')
  else:
    print(answer[0], answer[1])
