import sys

x_idx = [0,0,-1,1]
y_idx = [1,-1,0,0]
ans = 0
def process(map : list, k : int):
    start_idx = [(len(map)-1, 0), 1]
    end_idx = [(0, len(map[0])-1), k]
    map[len(map)-1][0] = 'X'
    dfs(map, start_idx, end_idx)

def dfs(map : list, idx : list, end_idx : list):
    if end_idx == idx:
         global ans
         ans += 1
    else :
        count = idx[1]
        point = idx[0]
        if count < end_idx[1]:
            for i in range(0,4):
                new_x_idx = point[1] - x_idx[i]
                new_y_idx = point[0] - y_idx[i]
                if new_x_idx >= 0 and new_x_idx < len(map[0]) and new_y_idx >= 0 and new_y_idx < len(map) \
                    and map[new_y_idx][new_x_idx] not in ('T','X'):
                    map[new_y_idx][new_x_idx] = 'X'
                    dfs(map, [(new_y_idx, new_x_idx), count + 1], end_idx)
                    map[new_y_idx][new_x_idx] = '.'
                    
def main():
    reader = sys.stdin.readline
    r, c, k = list(map(int, reader().split(' ')))
    data = []
    for _ in range(0, r):
        data.append(list(reader().strip()))
    process(data, k)
    global ans
    print(ans)


if __name__=='__main__':
    main()