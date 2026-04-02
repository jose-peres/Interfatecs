V = int(input())

if V <= 107:
    print(V + 7)
elif V > 107:
    print(round((0.07 * V) + V))
