S = input()

def is_letter(c):
  return 'A' <= c <= 'Z'

if S.isdigit() and len(S) <= 7:
  print('Placa numerica')
elif len(S) >= 2 and (S[0] == 'A' or S[0] == 'P') and S[1:].isdigit() and len(S) <= 6:
  print('Placa muito antiga')
elif len(S) == 6 and all(is_letter(c) for c in S[0:2]) and S[2:].isdigit():
  print('Placa AA-9999')
elif len(S) == 7 and all(is_letter(c) for c in S[0:3]) and S[3:].isdigit():
  print('Placa AAA-9999')
elif len(S) == 7 and all(is_letter(c) for c in S[0:3]) and S[3].isdigit() and is_letter(S[4]) and S[5:].isdigit():
  print('Placa Mercosul')
else:
  print('Placa invalida')
