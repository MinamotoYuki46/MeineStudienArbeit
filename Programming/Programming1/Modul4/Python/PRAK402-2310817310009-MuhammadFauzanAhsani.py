val = int(input())

for i in range(1, val+1):
    if (i % 2 == 1):
        print(f"{i} ", end ="")
print()
for j in range(val):
    if ((val - j) % 2 == 0):
        print(f"{val - j} ", end = "")
