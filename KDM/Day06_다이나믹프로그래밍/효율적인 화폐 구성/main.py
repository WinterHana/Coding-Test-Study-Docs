n, m = map(int, input().split())

coinList = []
for _ in range(n):
    coinList.append(int(input()))

dpTable = [99999] * 10001
# 동전 종류 중 0에 해당하는 동전은 없음
dpTable[0] = 0

# coin 종류마다 반복시킴. coinList은 정렬될 필요가 없음. 어차피 최소값으로 갱신할 거라서.
for coin in coinList:
    # 현재 시작 coin부터 목표 금액만큼만 순차반복시킴.
    for i in range(coin, m+1):
        # 현재 DP table에 저장된 값과 이전 인덱스에서 현재 coin을 1회 사용하여 만든 목표금액 중 더 작은 횟수로 갱신시킴.
        dpTable[i] = min(dpTable[i], dpTable[i-coin] + 1)

# 보유한 코인으로 목표 금액을 도달할 수 없는 경우 -1을 출력
if dpTable[m] == 99999:
    print(-1)
else:
    print(dpTable[m])