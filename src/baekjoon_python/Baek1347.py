'''
미로 만들기
홍준이는 미로 안의 한 칸에 남쪽을 보며 서있다.
미로는 직사각형 격자 모양, 각 칸은 이동할 수 있거나, 벽을 포함
모등 행과 열에는 적어도 하나의 이동할 수 있는 칸이 있음

입력으로 홍준이가 적은 내용을 나타내는 문자열이 주어짐
각 문자 하나는 한 번의 움직임을 말함
'F' 는 앞으로 한 칸, 'L', 'R' 은 방향을 왼쪽 또는 오른쪽으로 전환하는 것

- 입력
첫째 줄에 홍준이가 적은 내용의 길이가 주어짐 
길이는 0보다 크고, 50보다 작음
둘째 줄에 홍준이가 적은 내용이 주어짐

-출력
미로 지도 출력, '.'은 이동할 수 있는 칸, '#'은 벽
'''

import sys

n = sys.stdin.readline()
move_list = sys.stdin.readline().strip()

v = 1 # -1 = X, 1 = Y
d = 1
x_min = 0
y_min = 0
x_max = 0
y_max = 0
position_lst = [[0, 0]]
position = [0, 0]
for string in move_list:
    if string == 'R':
        if v == -1 :
            d *= 1
        else : d *= -1
        v *= -1
        
    elif string == 'L':
        if v == -1:
            d *= -1
        else : d *= 1
        v *= -1
        
    else :
        if v == -1:
            position[0] += d
        else : position[1] += d
        if position[0] < x_min : x_min = position[0]
        if position[1] < y_min : y_min = position[1]
        if position[0] > x_max : x_max = position[0]
        if position[1] > y_max : y_max = position[1]
        
        position_lst.append(list(position))

x_size = x_max - x_min
y_size = y_max - y_min
scaled_list = list(map(lambda x : [x[0] - x_min, x[1] - y_min] , position_lst))

for y in range(y_size+1):
    for x in range(x_size+1):
        if [x, y] in scaled_list:
            print('.', end='')
        else :
            print('#', end='')
    print()

