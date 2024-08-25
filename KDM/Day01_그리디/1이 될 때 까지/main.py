n, k = map(int, input("n과 k값 입력").split())

cnt = 0
# n이 1이 될 때까지만 반복
while( n > 1):
    # 나누어 떨어지는 경우에는 나눠주기
    if(n % k == 0):
        n = n / k
    # 그렇지 않은 경우에는 1을 빼주기
    else:
        n = n - 1

    cnt = cnt + 1

print(cnt)