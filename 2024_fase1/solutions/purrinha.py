QJ = int(input())
J = [input() for jogador in range(QJ)]
JP = [0 for jogador in range(QJ)]
NR = int(input())

for nr in range(NR):
    hand = sum(map(int, input().split()))
    
    pals = list(map(int, input().split()))
    for pal in range(len(pals)):
        if pals[pal] == hand: JP[pal] += 1

max_point = max(JP)
win = None
count = 0
for ptr_jp in range(QJ):
    if JP[ptr_jp] == max_point: win = J[ptr_jp]; count += 1
    if count > 1: print('EMPATE'); break
else:
    if max_point == 0: print('EMPATE')
    else: print(f'{win} GANHOU')