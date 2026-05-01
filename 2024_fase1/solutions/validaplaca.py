import re

s = input().strip()

def classify(s):
    if 1 < len(s) <= 6 and s[0] in "AP" and s[1:].isdigit():
        return "Placa muito antiga"

    if len(s) == 6 and s[:2].isalpha() and s[2:].isdigit():
        return "Placa AA-9999"

    if len(s) <= 7 and s.isdigit():
        return "Placa numerica"

    if len(s) == 7 and s[:3].isalpha() and s[3:].isdigit():
        return "Placa AAA-9999"

    if re.fullmatch(r"[A-Z]{3}\d[A-Z]\d{2}", s):
        return "Placa Mercosul"

    return "Placa invalida"

print(classify(s))
