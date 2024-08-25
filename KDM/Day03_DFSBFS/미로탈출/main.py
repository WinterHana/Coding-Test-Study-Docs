from collections import deque

n, m = map(int, input("n, m 입력").split())

graph = []
for _ in range(n):
    graph.append( list(map(int, input())) )

# 컨트롤러 생성(상하좌우)
moveList = [(-1, 0), (1, 0), (0,-1), (0,1)] 

def dfs(startX, startY):
    
    queue = deque([])
    queue.append((startX, startY))

    while queue:

        currentX, currentY = queue.popleft()

        # 상하좌우 이동
        for moveX, moveY in moveList:
            nextX = currentX + moveX
            nextY = currentY + moveY

            # 장외의 경우는 스킵
            if nextX < 0 or nextX >= n or nextY < 0 or nextY >= m:
                continue

            # 괴물이 없으면 이동
            # 최초 방문 노드만 취급
            if graph[nextX][nextY] == 1:
                graph[nextX][nextY] += graph[currentX][currentY]  # 현재 값에 이전 누적 카운트를 추가시킴 (헨델과 그레텔)
                queue.append( (nextX, nextY) ) 

    return graph[n-1][m-1]  # 미로의 출구는 반드시 (n, m)에 있다고 문제에 정의됨
        
print( dfs(0, 0) ) # 현재 위치를 기준으로 탐색 시작. 문제에서는 시작 위치를 (1,1)으로 정의했으나, 컴퓨터 상에서는 (0,0)으로 보아야 함