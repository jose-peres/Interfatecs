N = int(input())

div = 0
for n in range(2, N//2 + 1):
    if N % n == 0: div += 1
    if div > 1: print('nao'); break
else:
    if div == 0: print('nao')
    else: print('sim')