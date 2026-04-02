string = input()
letters = [
    'A',
    'B',
    'C',
    'D',
    'E',
    'F',
    'G', 
    'H',
    'I',
    'J', 
    'K',
    'L', 
    'M', 
    'N', 
    'O', 
    'P', 
    'Q', 
    'R', 
    'S', 
    'T', 
    'U', 
    'V', 
    'W', 
    'X', 
    'Y', 
    'Z']

def a():
    len_string = len(string)
    if len_string <= 6 and len_string > 1 and (string[0] == 'A' or string[0] == 'P'):
        for ptr_ch in range(len_string):
            if ptr_ch == 0: continue
            ch = string[ptr_ch]
            try:
                int(ch)
            except:
                break
        else: return 'Placa muito antiga'
    if len_string == 6 and (string[0] in letters) and (string[1] in letters):
        for ptr_ch in range(len_string):
            if ptr_ch <= 1: continue
            ch = string[ptr_ch]
            try:
                int(ch)
            except:
                break
        else: return 'Placa AA-9999'
    if len_string <= 7:
        for ch in string:
            try:
                int(ch)
            except:
                break
        else: return 'Placa numerica'

    if len_string == 7 and string[0] in letters and string[1] in letters and string[2] in letters:

        for ptr_ch in range(len_string):
            if ptr_ch <= 2: continue
            ch = string[ptr_ch]
            try:
                int(ch)
            except:
                break
        else: return 'Placa AAA-9999'

    if len_string == 7 and string[0] in letters and string[1] in letters and string[2] in letters:
        valid = True
        try:
            int(string[3])
        except:
            return'Placa invalida'
        if valid and not(string[4] in letters):
            return'Placa invalida'
        try:
            int(string[5])
            int(string[6])
        except:
            return'Placa invalida'
        
        if valid: return 'Placa Mercosul'

    return'Placa invalida'

print(a())