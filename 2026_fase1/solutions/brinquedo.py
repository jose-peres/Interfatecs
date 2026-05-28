N, K = map(int, input().split())

S = N*(N+1)//2

print('POSSIVEL' if S%K == 0 and N <= S//K else 'IMPOSSIVEL')
