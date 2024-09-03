import sys

n = int(input())
warehouse = list(map(int, sys.stdin.readline().split()))

dpTable = [0] * 1001
# 점화식 첫 부분만 수동으로 잡아줌
dpTable[1] = warehouse[0]
dpTable[2] = max(dpTable[1], warehouse[1])

# DP table 생성
for i in range(3, n+1):

    dpTable[i] = max(dpTable[i-1], dpTable[i-2] + warehouse[i-1])

print(dpTable[n])