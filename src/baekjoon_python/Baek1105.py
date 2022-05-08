import sys

def process(l : str, r : str) -> int:
    min_count = 0
    if len(l) == len(r):
        for idx in range(0, len(r)):
            if l[idx] == r[idx] :
                if l[idx] == '8':
                    min_count += 1
            else : break
    return min_count

def main():
    l, r = sys.stdin.readline().split()
    print(process(l, r))

if __name__=='__main__':
    main()