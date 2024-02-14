import sys

def main():
    s = sys.stdin.readline().strip()
    p = sys.stdin.readline().strip()
    
    if p in s:
        print(1)
    else :
        print(0)
    

if __name__=='__main__':
    main()