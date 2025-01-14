msg1 = input()
msg2 = input() 
result = ""
asterisk = 0
hash = 0

if (len(msg1) != len(msg2)):
    print("Panjang kalimat berbeda, pesan palsu")
else:
    for i in range(len(msg1)):
        if (msg1[i] == msg2[i]):
            if (msg1[i] == " "):
                continue
            result += "*"
            asterisk += 1
        else:
            result += "#"
            hash += 1
    print(result)
    print("* =", asterisk)
    print("# =", hash)
    
    if asterisk >= hash:
        print("Pesan Asli")
    else:
        print("Pesan Palsu")
