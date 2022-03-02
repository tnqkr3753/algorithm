import sys

x_list = [0,0,1,-1]
y_list = [-1,1,0,0]
def main():
    m, n = list(map(int, sys.stdin.readline().split()))
    box_list = []
    next_ripe = []
    for i in range(n):
        tmp_list = list(map(int, sys.stdin.readline().split()))
        for j in range(m):
            if tmp_list[j] == 1:
                next_ripe.append([i,j])
        box_list.append(tmp_list)
    count = 0
    if not next_ripe:
        if [row for row in box_list if 0 in row] : print(-1)
        else : print(count)
    else :
        while True:
            # print(f'curr {count}')
            # print(box_list)
            # print(f'next_ripe {next_ripe}')
            next_ripe = cul_next_ripe(box_list, next_ripe)
            if not next_ripe : break
            else : count += 1

        if [row for row in box_list if 0 in row] : print(-1)
        else : print(count)
    
def cul_next_ripe(box_list, cur_ripe):
    next_ripe = set()
    for x,y in cur_ripe:
        box_list[x][y] = 1

    for x,y in cur_ripe:
        for i in range(4):
            new_x = x + x_list[i]
            new_y = y + y_list[i]
            if new_x < 0 or new_y < 0 : continue
            try :
                val = box_list[new_x][new_y]
                if val == 0 : 
                    next_ripe.add((new_x, new_y))
            except IndexError as ie:
                pass
    return list(next_ripe)

if __name__ == '__main__':
    main()