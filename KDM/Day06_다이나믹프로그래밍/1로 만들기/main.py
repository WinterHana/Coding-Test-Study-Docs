x = int(input())

# DP 테이블 초기화
# d[1]은 무조건 0임
dpTable = [0] * 30001  # 1 ~ 30000
# dpTable[1] = 0

# DP table 만들기 >> x까지 순차적으로 올라감 (바텀업 다이나믹 프로그래밍 구현)
# dpTable[1]은 정의되어 있으므로 2부터 시작
for i in range(2, x+1):

    # 다음 선택지가 1을 뺀 선택지라고 하자.
    dpTable[i] = dpTable[i-1] + 1

    # 1을 뺀 선택지보다 나머지가 더 적은 연산이 가능하면 해당 값으로 변경.
    # 2, 3, 5 각각 모든 경우에 대해 비교하여 가장 적은 경우의 수를 찾아서 dpTable[i]를 결정함
    if i % 2 == 0:
        dpTable[i] = min(dpTable[i], dpTable[i // 2] + 1)
    if i % 3 == 0:
        dpTable[i] = min(dpTable[i], dpTable[i // 3] + 1)
    if i % 5 == 0:
        dpTable[i] = min(dpTable[i], dpTable[i // 5] + 1)

# 최종적으로 완성된 dpTable에서 x에 해당하는 값을 출력
print(dpTable[x])