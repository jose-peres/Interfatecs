while True:
  try:
    line = input().replace(' ', '').lower()
  except EOFError:
    break

  line=line.replace('ô','o')
  line=line.replace('ó','o')
  line=line.replace('õ','o')
  line=line.replace('é','e')
  line=line.replace('ê','e')
  line=line.replace('â','a')
  line=line.replace('á','a')
  #line=line.replace('ã','a')
  line=line.replace('.','')
  line=line.replace('"','')
  line=line.replace('?','')
  inverted = line[::-1]
  if line == inverted:
    print("Parabens, voce encontrou o Palindromo Perdido!")
  else:
    print("A busca continua, o Palindromo Perdido ainda nao foi encontrado.")
