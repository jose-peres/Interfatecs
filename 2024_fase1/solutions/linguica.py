N = int(input())

P = [0] + [int(input()) for _ in range(N)]

maxHeap = True
minHeap = True

for i in range(N, 1, -1):
    if P[i] > P[i//2]:
        maxHeap = False
    if P[i] < P[i//2]:
        minHeap = False

if maxHeap and minHeap:
    print(0)
elif maxHeap:
    print(2)
elif minHeap:
    print(1)
else:
    print(0)
