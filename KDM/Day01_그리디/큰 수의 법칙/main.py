n, m, k = map(int, input("N,M,K 입력").split())
numbers = list( map(int, input("입력할 수들을 입력").split()) )
numbers.sort(reverse=True)  # 원본 리스트를 내림차순으로 정렬

# 가장 큰 수를 최대한 많이 반복하면 됨. 개수 초기화 시에는 그 다음으로 큰 수를 딱 한 번 사용해주면 됨.
biggest = numbers[0]
secondary = numbers[1]

sum = 0
biggestCnt = int( m / (k + 1) ) * k + m % (k + 1)
sum += biggest * biggestCnt
sum += secondary * (m - biggestCnt)

print(sum)