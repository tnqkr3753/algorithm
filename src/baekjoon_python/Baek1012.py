import sys
# - 재귀한도 증가, 기본 1000
sys.setrecursionlimit(10**6)
x_idx = [0,0,1,-1]
y_idx = [-1,1,0,0]
def process(data: list) -> int:
    '''
    
    y : row
    x : col
    
    '''
    ans = 0
    for y in range(0, len(data)):
        for x in range(0, len(data[0])):
            ans +=search(data, x, y)
                
    return ans
def search(data:list, x:int, y:int):
    if data[y][x] == 1 :
        
        data[y][x] = 0
    
        for tmp_idx in range(0, 4):
            new_x = x + x_idx[tmp_idx]
            new_y = y + y_idx[tmp_idx]
            if new_x < 0 or new_x >= len(data[0]) or new_y < 0 or new_y >= len(data):
                continue
            search(data, new_x, new_y)
        return 1
    else : return 0

def main():
    reader = sys.stdin.readline
    t = int(reader())
    for _ in range(0,t):
        data = []
        m, n, k = list(map(int, reader().split()))
        [data.append([0] * m) for _ in range(0, n)]
        for _ in range(0, k):
            x, y = list(map(int, reader().split()))
            data[y][x]= 1
        print(process(data))

if __name__=='__main__':
    main()
    
    