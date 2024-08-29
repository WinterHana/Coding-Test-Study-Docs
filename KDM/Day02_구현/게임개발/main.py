n, m = map(int, input("n과 m을 입력").split())
x, y, direction = map(int, input("x, y와 바라보는 방향을 입력").split())
# 바라보는 방향
# 0 : 북쪽, 1: 동쪽, 2: 남쪽, 3: 서쪽

# 게임 맵을 생성
# 0: 육지, 1: 바다
myMap = list() 
for _ in range(n):
    myMap.append(list(map(int, input().split())))

# 게임 컨트롤러 (상하좌우)
# x축을 상하축, y축을 좌우축으로 잡아야 지도에서 값 조회 시 myMap[x][y] 형태로 조회 가능
moveList = [(-1, 0), (1, 0), (0, -1), (0, 1)]

# 게임 실행
cnt = 1  # 시작 칸은 항상 육지이므로 카운트하고 시작
missCnt=0  # 동서남북 전부 바다인지 확인용. 4가 되면 사면이 바다인 것
while(True):
    # 1. 현재 위치에서 바라보는 방향을 기준으로 반시계로 90도씩 탐색 (0 -> 3 -> 2 -> 1 -> 0)
    chooseDirection = -1
    if (direction == 0):
        chooseDirection = 3
    else:
        chooseDirection = direction - 1
    
    # 2-1. 탐색한 칸이 갈 수 있는 칸이면, 그 방향을 보게 회전한 다음 한 칸 전진
    direction = chooseDirection
    nextX = x + moveList[chooseDirection][0]
    nextY = y + moveList[chooseDirection][1]
    if myMap[nextX][nextY] == 0:
        myMap[x][y] = -1  # 기존에 있던 칸을 변경해서 방문 마킹
        x, y = nextX, nextY
        cnt += 1
    else:
        # 2-2. 탐색한 칸이 갈 수 없는 칸이면 그냥 회전만 함
        if missCnt < 4:
            missCnt += 1
            continue
        # 3-1. 동서남북 모든 방향이 이미 가본 칸이거나 바다인 경우, 현재 보는 방향을 유지한 채로 1보 후퇴
        # 3-2. 만약 후퇴해야 할 칸이 바다인 경우 게임 종료
        elif missCnt == 4:
            # 후퇴니까 뺄셈연산
            nextX = x - moveList[chooseDirection][0]
            nextY = y - moveList[chooseDirection][1]
            if myMap[nextX][nextY] == 1:
                break
            else:
                x, y = nextX, nextY
        # 시스템 오류
        else:
            print("오류")
        
print(cnt)