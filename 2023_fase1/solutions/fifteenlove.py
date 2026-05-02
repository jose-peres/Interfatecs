N = input() #ignore
results = input()

sets = [0,0]
games = [0,0]
points = [0,0]

serv = 0
recv = 1

tiebreak = False
lastServ = -1

for r in results:
  if r == 'W':
    w = serv
  else:
    w = recv
  l = (w+1)%2

  points[w] += 1
  if tiebreak:
    if points[w] >= 7 and points[w] > points[l] + 1:
      tiebreak = False
      games[w] += 1
      sets[w] += 1
      if sets[w] == 3:
        points[w] = 'GAME'
        break
      points[w] = points[l] = 0
      games[w] = games[l] = 0
      serv = lastServ
      recv = (serv+1)%2
    elif (points[w] + points[l])%2 == 1:
      serv = recv
      recv = (recv+1)%2
  else: #not tie-break
    if points[w] == 4 and points[l] == 4:
      points[w] = points[l] = 3
    elif points[w] >= 4 and points[w] > points[l] + 1:
      games[w] += 1
      if games[w] == 6 and games[l] == 6:
        tiebreak = True
        lastServ = serv
      elif games[w] >= 6 and games[w] > games[l] + 1:
        sets[w] += 1
        if sets[w] == 3:
          points[w] = 'GAME'
          break
        games[w] = games[l] = 0
      points[w] = points[l] = 0
      serv = recv
      recv = (recv+1)%2


gameScore = [0,15,30,40,'ADV']

print(f"{sets[0]}({games[0]})[", end='', sep='')
print(points[0] if tiebreak else 'GAME' if points[0] == 'GAME' else gameScore[points[0]], end='')
print(f"]-{sets[1]}({games[1]})[", end='', sep='')
print(points[1] if tiebreak else 'GAME' if points[1] == 'GAME' else gameScore[points[1]], end='')
print(']')
