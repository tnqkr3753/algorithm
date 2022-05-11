import sys

def process(n : int, k : int):
    ans = 0
    while True:
        b_n = bin(n)
        if b_n.count('1') > k:
            i = b_n[::-1].index('1') 
            v = 1<<i
            ans += v
            n += v
        else : break
    return int(ans)
    

def main():
    n, k = list(map(int, sys.stdin.readline().split(' ')))
    print(process(n, k))

if __name__=='__main__':
    main()