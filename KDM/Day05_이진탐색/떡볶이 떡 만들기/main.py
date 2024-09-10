import sys

n, m = map(int, input().split())

riceCakeHeightList = list(map(int, sys.stdin.readline().split()))

# 가능한 떡 길이의 범위를 최대로 잡아줌
startHeight = 0  
endHeight = 1000000000  
result = -1  # 조건을 만족하는 떡 길이
while startHeight <= endHeight:

    midHeight = (startHeight + endHeight) // 2  # 떡 자를 기준 길이

    total = 0  # 남는 떡의 최종 길이    
    # 전체 떡들에 대해서 커팅식
    for selectedHeight in riceCakeHeightList:
        if(midHeight < selectedHeight):
            total += (selectedHeight - midHeight)

    # 필요 이상으로 남는 떡의 길이가 긴 경우, 자르는 떡의 길이가 지금보다 긴 쪽으로 탐색 진행
    if total >= m:
        startHeight = midHeight + 1
        result = midHeight
    # 남는 떡의 길이가 부족한 경우, 자르는 떡의 길이가 지금보다 짧은 쪽으로 탐색 진행
    else:
        endHeight = midHeight - 1

print(result)