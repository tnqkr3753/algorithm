import sys

segment_dict = {
        '0111111' : '0',
        '0001010' : '1',
        '1011101' : '2',
        '1001111' : '3',
        '1101010' : '4',
        '1100111' : '5',
        '1110111' : '6',
        '0001011' : '7',
        '1111111' : '8',
        '1101011' : '9',
    }

number_dict = {v : k for k, v in segment_dict.items() }

def main():
    
    while True:
        line = sys.stdin.readline().strip()
        if line == "BYE":
            break
        code_a, code_b = line.split('=')[0].split('+')
        a = get_number(code_a)
        b = get_number(code_b)
        sum = a + b
        print(f'{code_a}+{code_b}={get_code(sum)}')
        

def get_number(code : str) -> int:
    segs = [int(code[i:i+3])for i in range(0, len(code), 3)]
    results = []
    for seg in segs:
        results.append(segment_dict['{0:07b}'.format(seg)])
    
    return int(''.join(results))

def get_code(number : int) -> str:
    results = []
    for s in str(number):
        results.append(str(int(number_dict[s], base=2)).zfill(3))
        
    return ''.join(results)

if __name__=='__main__':
    main()