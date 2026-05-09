classes = [
  'ALGORITMOS',
  'BOAS PRATICAS',
  'DESEMPENHO',
  'FLUXOGRAMAS',
  'INTERPRETACAO DE ENUNCIADOS',
  'SINTAXE DA LINGUAGEM'
]

V = int(input())

spots = [[] for _ in range(6)]
out = []
student_count = 0

while True:
  try:
    line = input().split()
  except EOFError:
    break
  student = line[0]
  category = [int(n) for n in line[1:]]
  if student_count < V:
    student_count += 1
    for i in category:
      spots[i-1].append(student)
  else:
    out.append(student)

for i in range(6):
  print('------------------------------')
  print(classes[i])
  print('------------------------------')
  spots[i].sort()
  for student in spots[i]:
    print(student)
  if i < 5:
    print()

if out:
  print()
  print('------------------------------')
  print('FICA PARA A PROXIMA!')
  print('------------------------------')
  for student in out:
    print(student)
