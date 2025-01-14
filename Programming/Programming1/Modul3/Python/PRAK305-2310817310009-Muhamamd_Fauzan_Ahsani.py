sec = int(input())

hours = sec // 3600

minutes = sec // 60
if minutes >= 60:
    minutes = minutes - (minutes//60 * 60)

seconds = sec % 60

if hours >= 24:
    days = hours // 24
    hours = hours - days * 24
    print(f"{days} hari {hours:02d}:{minutes:02d}:{seconds:02d}")
else:
    print(f"{hours:02d}:{minutes:02d}:{seconds:02d}")