import sys

n = 0 
result_lst = []
count = 0

x_lst = [0,0,1,-1]
y_lst = [1,-1,0,0]

def main():
    n = int(sys.stdin.readline())
    lst = [list(sys.stdin.readline()) for _ in range(n)]
    
    # row
    for i in range(n):
        # col
        for j in range(n):
            if search(lst, n, i, j)==True:
                global count
                result_lst.append(count)
                count = 0

    result_lst.sort()

    print(len(result_lst))
    for result_cnt in result_lst:
        print(result_cnt)

def search(lst, n, x, y):

    if x < 0 or x >= n or y < 0 or y >= n :
        return False
    
    if lst[x][y] == "1":
        global count

        count += 1
        lst[x][y] = "0"
        
        for i in range(4):
            new_x = x + x_lst[i]
            new_y = y + y_lst[i]
            search(lst, n, new_x, new_y)
        return True
    else :
        return False


if __name__ == '__main__':
    main()