from math import cos, sin

N, theta = map(int, input().split())
theta = 3.1415*theta/180

m = [cos(theta), -sin(theta)]

for _ in range(N):
    x, y = map(int, input().split())

    xp = m[0]*x + m[1]*y
    yp = -m[1]*x + m[0]*y
    print(f"{xp:.2f} {yp:.2f}")
