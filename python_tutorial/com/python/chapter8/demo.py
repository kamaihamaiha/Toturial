# 8-1 消息
def display_message():
    """输出本章学到的内容"""
    print('我在这章学到了函数的知识！')


# 调用函数
display_message()


# 8-2 喜欢的图书
def favorite_book(title):
    print('我喜欢的书是： ' + title)


# 调用函数
favorite_book('《黑铁时代》')


# 8-3 T恤
def make_shirt(size=10, tips='你的能量超忽你想象！'):
    print('T恤的尺码是： ' + str(size) + '码')
    print('字样是： ' + tips)


# 调用函数
make_shirt()
make_shirt(15)
make_shirt(10, '一切皆有可能！')
make_shirt(tips='要啥自行车？！', size=30)


# 8-4 大号 T恤
def make_shirt2(size='大', tips='I love Python'):
    print(size + '号 T恤上写着： ' + tips)


# 调用函数
make_shirt2()
make_shirt2('中')
make_shirt2('中', '我的地盘我做主！')


# 8-5 城市
def decribe_city(name, country='China'):
    print(name + ' is in ' + country)


# 调用函数
decribe_city('HK')
decribe_city('New York', 'USA')
decribe_city('London', 'Uk')


# 8-6 城市名
def city_country(city_name, country):
    return city_name + ', ' + country


# 调用函数
print(city_country('北京', '中国'))
print(city_country('东京', '日本'))
print(city_country('伦敦', '英国'))


# 8-7 专辑
def make_album(author, album, num=''):
    if num:
        return {'author': author, 'album': album, 'num': num}
    else:
        return {'author': author, 'album': album}


# 调用函数
print(make_album('张国荣', 'Monica'))
print(make_album('歌手1', '专辑1', 9))
print(make_album('歌手2', '专辑2'))

# 8-8 用户的专辑

while True:
    print('Press "q" exit!')
    author = input('Please input author: ')
    if author == 'q':
        break
    album = input('Please input album: ')
    if album == 'q':
        break
    print(make_album(author, album))

# 8-9 魔术师
magicians = ['刘谦', '大卫.可波菲尔', '傅腾龙']

def show_magicians(magicians):
    for magician in magicians:
        print('------ ' + magician)


# 调用函数
show_magicians(magicians)

# 8-10 了不起的魔术师
def make_great(magicians):
    for i in range(len(magicians)):
        magicians[i] = '伟大的' + magicians[i]

make_great(magicians)
show_magicians(magicians)

# 8-11 不变的魔术师
print('--------------------------不变的魔术师---------')
def make_great2(magicians):
    for i in range(len(magicians)):
        magicians[i] = '伟大的' + magicians[i]

    return magicians

magic5 = ['魔术师1','魔术师2','魔术师3']
magic6 = make_great2(magic5[:])

show_magicians(magic5)
show_magicians(magic6)

# 8-12 三明治
print('--------------------------三明治---------')
def accept_foods(*foods):
    print('顾客点的三明治：')
    print(foods)

# 调用函数
accept_foods('鸡蛋')
accept_foods('鸡蛋','辣椒')
accept_foods('鸡蛋','辣椒','胡萝卜')

# 8-13 用户简介·「我这边用汽车简介」
print('---------------------------汽车简介')
def create_car(brand, country, **car_info):
    car = {}
    car['brand'] = brand
    car['country'] = country
    for key, value in car_info.items():
        car[key] = value
    return car

good_car = create_car('Toyota','Japan',type='86',racer='Takmi')
print('我有一辆 ' + good_car['brand'] + ' 牌的车，它产自 ' + good_car['country'] + '。它的型号是：' + good_car['type'] + ',因 '
      + good_car['racer'] + ' 而闻名于世！')

# 8-14 汽车。
# 巧了，我上个题就没按照书本来，用汽车替代了用户简介，这个 14 题，就不用写了。

# 8-15 打印模型
# 见文件 printing_fuctions.py

# 8-16 导入
from com.python.chapter8 import human
human.eat('画饼')

from com.python.chapter8.human import eat
eat('葱花饼')

from com.python.chapter8.human import eat as bite
bite('面包')

from com.python.chapter8 import human as hm
hm.eat('蜂蜜')

from com.python.chapter8.human import *
eat('牛排！')