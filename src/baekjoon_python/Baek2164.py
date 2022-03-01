import sys
from collections import deque

def shuffle(q: deque) -> deque:
    q.pop()
    q.rotate(1)

def main():
    n = int(sys.stdin.readline())
    queue = deque(reversed(range(1,n+1)), n)
    while len(queue) != 1:
        shuffle(queue)
    print(queue.pop())

if __name__ == '__main__':
    main()
