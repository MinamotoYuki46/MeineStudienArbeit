nilai = int(input())

if nilai >= 80:
    print("A")
elif nilai <= 79 and nilai >= 70:
    print("B")
elif nilai <= 69 and nilai >= 60:
    print("C")
elif nilai <= 59 and nilai >= 50:
    print("D")
elif nilai < 50:
    print("E")