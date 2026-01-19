N, P = [x for x in input().split()]
N = int(N)

alphabet = [chr(ord('A')+i) if P == 'maiusculas' else chr(ord('a')+i) for i in range(N)] 

for i in range(1,N+1):
  for j in range(26-i):
    print('.', end='')
  print(''.join(alphabet[:i]))
