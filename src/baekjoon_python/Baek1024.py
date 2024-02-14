'''
N과 L이 주어질 때, 합이 N이면서, 길이가 적어도 L 이상인 가장 짧은 연속된 음이 아닌 정수 리스트를 구하는 프로그램 작성

- 입력
첫째 줄에 N, L이 주어지고 N은 1,000,000,000보다 작거나 같은 자연수, L은 2보다 크거나 같으며, 100보단 작음

- 출력
리스트의 길이가 100보다 작거나 같으면, 연속된 수를 첫째 줄에 공백으로 구분하여 출력, 만약 100보다 크거나 그러한 수열이 없을 경우 -1 출력
'''
import sys
import math

n, l = tuple(map(int, sys.stdin.readline().split()))


while True:
    m = math.ceil(n/l) - int(l/2) 
    if m < 0 or l > 100:
        print(-1)
        break
    lst = []
    for i in range(m, m + l):
        lst.append(i)
    if sum(lst) == n:
        for i in lst :
            print(i, end=' ')
        print()
        break
    else :
        l += 1 
        continue
    