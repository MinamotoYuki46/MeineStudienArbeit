import numpy as np

row, column = map(int, input().split())
number = list(map(int, input().split()))

array = np.array(number).reshape(row, column)

for i in array:
    for j in i:
        print(j, end=" ")
    print()