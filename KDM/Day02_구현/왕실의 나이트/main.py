# 가로 : a~h
# 세로 : 1 ~ 8
temp = input("좌표 입력")
x, y = temp[0], int(temp[1])

# 연산하기 쉽게 숫자로 변환
x = ord(x) - ord('a') + 1

# 이동 가능한 모든 경우의 수를 리스트업
moveList = [(1,2), (2,1), (-1,2), (-2,1), (1,-2), (2,-1), (-1,-2), (-2,-1) ]

# 완전탐색
cnt = 0
for moveX, moveY in moveList:
    nextX = x + moveX
    nextY = y + moveY

    # 범위를 넘어서는 경우 무시
    if(nextX < 1 or nextX > 8 or nextY < 1 or nextY > 8):
        continue
    # 그 외의 경우에는 카운트
    else:
        cnt += 1

print(cnt)