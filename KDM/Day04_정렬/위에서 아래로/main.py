n = int(input("n"))

sequence = []
for _ in range(n):
    sequence.append(int(input()))

sequence.sort(reverse=True)
for i in sequence:
    print(i, end= " ")