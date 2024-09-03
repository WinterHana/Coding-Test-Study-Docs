n = int(input("n"))

scoreList=[]
for _ in range(n):
    temp = input().split()
    scoreList.append( (temp[0], temp[1]) )

scoreList = sorted(scoreList, key=lambda x: x[1])  # 성적순으로 정렬 (오름차순)

for x in scoreList:
    print(x[0], end=" ")