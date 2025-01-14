import numpy as np

column = int(input())
number = list(map(int, input().split()))

array = np.array(number).reshape(1, column)
scale = 1

for i in array:
    for j in i:
        print(j * scale, end=" ")
        scale += 1