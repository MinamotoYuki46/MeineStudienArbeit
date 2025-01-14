def maksimal(a:int, b:int):
    if (a > b):
        return a
    else:
        return b

def minimal(a:int, b:int):
    if (a < b):
        return a
    else:
        return b

batas = 0
maks = -100000
minim = 100000
bilangan = int(input())
nilai = list(map(int, input().split()))

while batas < bilangan:
    maks = maksimal(maks, nilai[batas])
    minim = minimal(minim, nilai[batas])
    batas += 1

print(f"{maks} {minim}")