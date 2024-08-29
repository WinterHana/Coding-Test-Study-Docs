n, m = map(int, input("n, m 입력 : ").split())

graph = []  # 그래프를 전역 변수로 정의
for _ in range(n):
    graph.append(list(map(int, input())))  # 하나의 숫자를 list에 넣으면 자릿수에 따라 분리되어 들어감

def dfs(x,y):
    # 1. 시작 노드를 기점으로 상하좌우로 DFS 탐색 실행
    # 2. 방문 또는 체크한 노드는 -1로 변경하여 마킹
    # 3. 더 이상 탐색할 노드가 없는 경우 탐색 종료
    
    # 얼음 틀을 벗어나는 경우 탐색 종료
    if x < 0 or x >= n or y < 0 or y >= m:
        return False

    # 구멍 뚫린 부분을 찾은 경우에 탐색 진행
    if graph[x][y] == 0:
        graph[x][y] = -1  # 방문한 노드는 -1로 변경하여 마킹

        # 상하좌우로 DFS 탐색 수행 (return은 모두 False이지만, 탐색 가능한 노드를 전부 뒤집어버리는 것이 목표임)
        dfs(x-1, y)
        dfs(x, y-1)
        dfs(x+1, y)
        dfs(x, y+1)

        return True

    # 칸막이 또는 이미 방문한 노드를 찾은 경우 탐색 종료
    else:
        return False

cnt = 0
for x in range(n):
    for y in range(m):
        if dfs(x, y) == True:
            cnt += 1

print(cnt)