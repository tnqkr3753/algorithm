import sys
from math import gcd #최대공약수 함수

if __name__ == '__main__':

    n, m = list(map(int,sys.stdin.readline().split()))
    gcdNm = gcd(n,m)
    print(gcdNm)
    print((n*m) // gcdNm)

    