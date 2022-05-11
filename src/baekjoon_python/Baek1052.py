import sys

def process(n : int, k : int):
    """_summary_

    Args:
        n (int): _description_
        k (int): _description_

    Returns:
        ans: _description_
    """    
    ans = 0
    divide_count = 0
    cannot_move = 0
    while True:
        if n <= 0 or k == 0:
            break
        minus_value = 1<< divide_count
        value = n - minus_value
        
        if value < 0:
            ans =  abs(value)
            k -= 1
            n -= 1 << (divide_count-1)
            
            divide_count = 1
            
        else : divide_count +=1 
        
    return int(ans)
    

def main():
    n, k = list(map(int, sys.stdin.readline().split(' ')))
    print(process(n, k))

if __name__=='__main__':
    main()