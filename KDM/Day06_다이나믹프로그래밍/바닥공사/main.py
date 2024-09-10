n = int(input())

dpTable = [0] * 1001
dpTable[1] = 1
dpTable[2] = 3

# 마지막에 2*2 타일을 설치하는 경우 : dpTable[i-2] 
# 마지막에 1*2 타일 2개를 설치하는 경우 : dpTable[i-2] 
# 마지막에 2*1 타일을 설치하는 경우 : dpTable[i-1] 
for i in range(3, n+1):
    dpTable[i] = (dpTable[i-2] * 2) + (dpTable[i-1])

print(dpTable[n] % 796796)