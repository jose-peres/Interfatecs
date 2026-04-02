Q = int(input())
PI = list(map(int, input().split()))
for n in range(int(input())):
    A = input().split()
    NOME = A[0]
    QUANT = list(map(int, A[1:]))

    div = []
    for q in range(Q):
        div.append(QUANT[q] // PI[q])
    print(NOME, min(div))