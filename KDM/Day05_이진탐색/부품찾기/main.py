import sys

n = int(input())

posessionSet = set(map(int, sys.stdin.readline().split()))

m = int(input())

for requestNumber in list(map(int, sys.stdin.readline().split())):
    if requestNumber in posessionSet:
        print("yes", end=" ")
    else:
        print("no", end=" ")