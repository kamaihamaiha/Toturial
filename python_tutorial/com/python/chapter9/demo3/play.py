from com.python.chapter9.demo3.die import Die
# 玩骰子

print('----------------------------- 玩掷骰子，6面')
die_6_sides = Die()
for index in range(1,10):
    print('掷骰子结果： ' + str(die_6_sides.roll_sides()) + '点！')

print('----------------------------- 玩掷骰子，10面')
die_10_sides = Die(10)
for index in range(1,10):
    print('掷骰子结果： ' + str(die_10_sides.roll_sides()) + '点！')

print('----------------------------- 玩掷骰子，20面')
die_20_sides = Die(20)
for index in range(1,10):
    print('掷骰子结果： ' + str(die_20_sides.roll_sides()) + '点！')