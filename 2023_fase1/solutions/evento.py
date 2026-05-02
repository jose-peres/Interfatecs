from collections import deque

def reach_all(graph, start, n):
  visited = [False for _ in range(n+1)]
  queue = deque([start])
  visited[start] = True
  visited_count = 1

  while queue:
    j = queue.popleft()
    for l in graph[j]:
      if not visited[l]:
        visited[l] = True
        visited_count += 1
        queue.append(l)

  return visited_count == n

while True:
  N, M = [int(x) for x in input().split()]
  if (N, M) == (0, 0):
    break

  places = [[] for _ in range(N+1)]
  reversed_places = [[] for _ in range(N+1)]
  for _ in range(M):
    V, W, D = [int(x) for x in input().split()]
    places[V].append(W)
    reversed_places[W].append(V)
    if D == 2:
      places[W].append(V)
      reversed_places[V].append(W)
  
  if reach_all(places, 1, N) and reach_all(reversed_places, 1, N):
    print('S')
  else:
    print('N')
