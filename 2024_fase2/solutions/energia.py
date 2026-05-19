E, L = [int(n) for n in input().split()]

links = [[int(n) for n in input().split()] for _ in range(L)]
links.sort(key=lambda x:x[2])

total = 0

parent = [v for v in range(E+1)]
rank = [0 for _ in range(E+1)]
def Find(v):
  if v != parent[v]:
    parent[v] = Find(parent[v])
  return parent[v]
def Union(r, s):
  if rank[r] > rank[s]:
    parent[s] = r
  else:
    parent[r] = s
    if rank[r] == rank[s]:
      rank[s] += 1

for u, v, cost in links:
  r = Find(u)
  s = Find(v)
  if r != s:
    total += cost
    Union(r, s)

print(total)

# https://www.ime.usp.br/~pf/analise_de_algoritmos/aulas/MST-kruskal.html

# and

# https://www.ime.usp.br/~pf/analise_de_algoritmos/aulas/union-find.html
