h, f, n = [float(i) for i in input().split()]
n = int(n)
soma=h
for _ in range(n-1):
    h=h*f
    soma+=h*2

print("Total distance:",f"{soma:.2f}")