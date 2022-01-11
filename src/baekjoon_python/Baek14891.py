import sys
def turnGear(gear:list, drctn:int) -> None:
    if drctn == -1 : 
        gear.insert(7,gear.pop(0))
    else :
        gear.insert(0,gear.pop(7))

def gearProcess(gearList:list, idx:int, drctn:int, depth:int) -> None:
    gear = gearList[idx]
    prevIdx = idx-1
    nextIdx = idx+1
    if depth <= 0 : #진행방향 왼쪽
        if prevIdx >= 0 and gearList[prevIdx][2] != gear[6] :
            gearProcess(gearList, prevIdx, drctn * -1 , -1)

    if depth >= 0 : #진행방향 오른쪽
        if nextIdx <= 3 and gearList[nextIdx][6] != gear[2] :
            gearProcess(gearList, nextIdx, drctn * -1 , 1)
    turnGear(gear, drctn)



def main():
    gearList = []
    for item in range(4):
        gearList.append(list(sys.stdin.readline()))
        
    n = int(sys.stdin.readline())
    for i in range(n):
        idx, drctn = list(map(int,sys.stdin.readline().split(' ', 1)))
        gearProcess(gearList, idx-1, drctn, 0)
    score = 0
    for index in range(4): 
        score = score + ((1 << index ) * int(gearList[index][0]))
    print(score)
    
if __name__=='__main__':
    main()