import sys
from math import sqrt

def process(data : list) -> int:
    '''process Function

    if 
    
    '''
    jo = (data[0], data[1])
    baek = (data[3], data[4])
    r = (data[2], data[5])
    distance = sqrt((jo[0]-baek[0])**2 + (jo[1]-baek[1])**2)

    if distance == 0 and r[0] == r[1]: return -1
    elif abs(r[0]-r[1]) == distance or sum(r) == distance: return 1
    elif abs(r[0]-r[1]) < distance and sum(r) > distance : return 2
    else : return 0

def main():
    '''Main Function

    get System input, then Process.
    finally print result

    '''
    t = int(sys.stdin.readline())
    data = []
    for _ in range(0, t):
        print(process(list(map(int, sys.stdin.readline().strip().split(' ')))))


if __name__=='__main__':
    main()