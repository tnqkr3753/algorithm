import sys

#- Main
def main():
    #- 입력을 받아 시작값, 종료값 받기
    m,n = list(map(int,sys.stdin.readline().split(' ')))
    #- min수 부터 max수까지 배열 생성( 인덱스 번호가 수로 가정 )
    m = m if m > 1 else 2
    #- 범위만큼 True 배열 생성
    numList = [True] * (n+1)
    #- 2부터 n까지
    for i in range(2, n+1):
        #- 없어진 수를 False로 생각하여 없는 수는 continue
        if not numList[i] : continue
        #- 없어지지 않고 i가 m보다 크거나 같으면 출력
        if i >= m : print(i)
        #- 출력 후 출력한 수의 배수들을 false로 전환
        for j in range(i+i, n+1, i):
            numList[j] = False



if __name__ == '__main__':
    main()