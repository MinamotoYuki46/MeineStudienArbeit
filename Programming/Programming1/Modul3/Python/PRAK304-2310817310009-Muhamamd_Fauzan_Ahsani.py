nilai = int(input())

if nilai >= 100:
    print("Anda Menginput Melebihi Limit Bilangan")
elif nilai == 10 or nilai >=20 and nilai <=99:
    print("Puluhan")
elif nilai >= 11 and nilai <= 19:
    print("Belasan")
elif nilai < 10 and nilai > 0:
    print("Satuan")
elif nilai == 0:
    print("Nol")