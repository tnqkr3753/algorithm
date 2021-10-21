import sys

def getChar(M):
    sub_str_M_list = []
    while M:
        sub_str_M_list.append(int(M % 10)) 
        M = int(M / 10)
    return sum(sub_str_M_list)
        

def processing(N, M):
    result_M = 0
    for sub_M in range(M,N):
        if sub_M + getChar(sub_M) == N : result_M = sub_M
        else : continue
        break
    
    print(result_M)

def main(): 
    N = sys.stdin.readline().strip()
    int_N = int(N)
    if int_N > 10 :
        start_M = int_N - (len(N) * 9)
    else :
        start_M = 1
    processing(int_N, start_M)

if __name__ == '__main__':
    main()