var = input().split()
val1, val2 = map(int, var)

for i in range(abs(val1 - val2) + 1):
    if (val1 < val2):
        if (i == abs(val1 - val2)):
            print(f"{val1 + i} {val2 - i}", end = "")
        else:
            print(f"{val1 + i} {val2 - i} - ", end = "")
    elif (val1 > val2):
        if (i == abs(val1 - val2)):
            print(f"{val1 - i} {val2 + i}", end = "")
        else:
            print(f"{val1 - i} {val2 + i} - ", end = "")