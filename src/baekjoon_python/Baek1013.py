import sys
import re
'''

pattern : (100+1+ | 01)+
10* 1+ | 01

'''

def process(data : str, reg : re.Pattern) -> str:
    result = 'NO'
    if reg.fullmatch(data):
        result = 'YES'
    return result

def main():
    reg = re.compile(r'((100(0)*(1)+)|(01))+')
    reader = sys.stdin.readline
    t = int(reader())
    for _ in range(0, t):
        print(process(reader().strip(), reg))
    
if __name__=='__main__':
    main()