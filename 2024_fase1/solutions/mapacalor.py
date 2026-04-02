N = int(input())
screen = []
sup, esq, dir, inf, cen = 0, 0, 0, 0, 0
for sceen in range(N):
    for n in range(6):
        line = list(map(int, input().split()))
        if n == 0:
            sup += sum(line)
        elif n == 5:
            inf += sum(line)
        else:
            esq += line[0]
            cen += line[1]
            dir += line[2]


lados = [sup, esq, cen, dir, inf]
nome = ['superior', 'esquerda', 'centro', 'direita', 'inferior']
maior = 0
idx = 0
for n in range(5):
    if lados[n] > maior:
        maior = lados[n]
        idx = n
print(nome[idx])