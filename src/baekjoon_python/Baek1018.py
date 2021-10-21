import sys
class Board:
    def __init__(self, N, M):
        self.row = N
        self.col = M
        self.board = []

    def inputRow(self, row):
        self.board.append(row)

    def getLowerFix(self):
        min_fix = 50 * 50
        for x in range(0,self.col - 7):
            for y in range(0,self.row - 7):
                    sub_board = self.board[0+y:8+y]
                    fix_cnt = 64
                    for color in ['B','W']:
                        count = 0
                        for idx,row in enumerate(sub_board):
                            sub_row = row[0+x:8+x]
                            if idx % 2 == 0:
                                count += len([col for col in sub_row[0:8:2] if col != color ])
                                count += len([col for col in sub_row[1:8:2] if col == color ])
                            else :
                                count += len([col for col in sub_row[0:8:2] if col == color ])
                                count += len([col for col in sub_row[1:8:2] if col != color ])
                        if fix_cnt > count : fix_cnt = count
                    if min_fix > fix_cnt : min_fix = fix_cnt
                        
        print(min_fix)

def getInput():
    input_list = sys.stdin.readline().strip().split()
    N = int(input_list[0])
    M = int(input_list[1])
    board = Board(N, M)
    [ board.inputRow(sys.stdin.readline().strip()) for cnt in range(0,N) ]
    return board

def main():
    getInput().getLowerFix()

if __name__ == '__main__':
    main()