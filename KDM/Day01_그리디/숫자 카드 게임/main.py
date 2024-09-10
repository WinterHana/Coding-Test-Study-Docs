n, m = map(int, input("n, m 값을 입력").split())

# n번 반복하며 카드 행 내 최소값이 크면 갱신
minVal = 1
for i in range(n):
    # 카드 행을 항상 내림차순으로 정렬 후 append
    temp = list(map(int, input("카드 행을 입력").split()))
    temp.sort()
    if(minVal < temp[0]):
        minVal = temp[0]

print(minVal)
```

```python
n, m = map(int, input("n, m 값을 입력").split())

# n번 반복하며 카드 행 내 최소값이 크면 갱신
minVal = 1
for i in range(n):
    # 카드 행을 항상 내림차순으로 정렬 후 append
    temp = list(map(int, input("카드 행을 입력").split()))
    tempMinVal = min(temp)
    if(minVal < tempMinVal):
        minVal = tempMinVal

print(minVal)