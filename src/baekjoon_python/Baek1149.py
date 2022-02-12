import sys
read_std = sys.stdin.readline
def main():
    n = int(read_std())
    rgb_list = [list(map(int,read_std().split()))]
    for i in range(1, n):
        r, g , b = list(map(int,read_std().split()))
        prev_idx = i-1
        tmp_list = []
        tmp_list.append(min(rgb_list[prev_idx][1],rgb_list[prev_idx][2]) + r)
        tmp_list.append(min(rgb_list[prev_idx][0],rgb_list[prev_idx][2]) + g)
        tmp_list.append(min(rgb_list[prev_idx][0],rgb_list[prev_idx][1]) + b)
        rgb_list.append(tmp_list)

    print(min(rgb_list[n-1]))
            

if __name__=='__main__':
    main()