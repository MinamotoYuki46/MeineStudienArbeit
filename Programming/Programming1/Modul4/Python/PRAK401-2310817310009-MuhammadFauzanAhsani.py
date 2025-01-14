array = input().split(" ")
val = int(array[0])
symbol = array[1]

for i in range(1, 51):
    if (i  % val == 0):
        print(f"{symbol} ", end ="")
    else:
        print(f"{i} ", end = "")