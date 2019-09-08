# 8.1 定义函数
def greet():
    """打招呼"""
    print('你好！')


# 调用函数
greet()


# 8.1.1 向函数传递信息
def greet2(name):
    """打招呼"""
    print('你好，' + name + '!')


# 调用函数
greet2('帅哥')


# ===========================传递实参=================================
# 8-2 传递实参
# 8-2-1 位置实参
def pet_describe(pet_type, pet_name):
    print('I have a ' + pet_type)
    print('It' + "'s name is " + pet_name + '!')


# 调用函数
pet_describe('cat', 'Hello Kitty')
pet_describe('dog', 'Leo')

# 8-2-2 关键字实参
# 就是在调用函数的时候直接给形式参数赋值，这样就不用担心参数传递的顺序了。
pet_describe(pet_type='狗', pet_name='瓦利')


# 8-2-3 默认值
# 可以给形参指定默认值，这样调用函数时，可不给此形参传递值
def pet_describe2(pet_name, pet_type='dog'):
    print('I have a ' + pet_type)
    print('It' + "'s name is " + pet_name + '!')


# 2 种调用方式都行
pet_describe2('八工')
pet_describe2(pet_name='啸天犬')


# ===========================传递实参=================================
# 8-3 返回值
# 8-3-1 返回简单的值
def get_formatted_name(first_name, last_name):
    full_name = first_name.title() + ' ' + last_name.title()
    return full_name


# 调用函数
super_star = get_formatted_name('Leslie', 'Cheung')
print(super_star)


# 8-3-2 让实参变成可选的
# 有的人有中间名，所以需要再加一个参数。但是这个参数要给个默认值：空字符串，并且移动到形参列表末尾。
def get_formatted_name2(first_name, last_name, middle_name=''):
    if middle_name:
        full_name = first_name.title() + ' ' + middle_name.title() + ' ' + last_name.title()
    else:
        full_name = first_name.title() + ' ' + last_name.title()
    return full_name


# 调用函数
print(get_formatted_name2('Hello', 'Kitty'))
print(get_formatted_name2('Hello', 'Kitty', 'cat'))


# 8-3-3 返回字典
def build_person(name, age, gender):
    """返回一个字典，包含一个人的信息"""
    person = {'name': name, 'age': age, 'gender': gender}
    return person


# 调用函数
print(build_person('张三丰', 23, '男'))

# 8.3.4 在 while 循环中使用函数

# 就用 get_formatted_name2 演示

while True:
    print('按下 "q" 退出')
    f_name = input('请输入名字： ')
    if (f_name == 'q'):
        break

    l_name = input('请输入姓氏： ')
    if l_name == 'q':
        break

    print(get_formatted_name2(f_name, l_name))


# ===========================传递列表=================================
# 8.4 传递列表

def greet_users(users):
    """向列表的每一位用户发出问候"""
    for user in users:
        print(user.title() + ', 你好！')


greet_users(['ali', 'bell', 'cristin', 'Dany'])

# 8.4.1 在函数中修改
print('---------------------------在函数中修改----------')


def carry(src_list, des_list):
    while src_list:
        cur = src_list.pop()
        print('打印到： ' + cur)
        des_list.append(cur)


def show_des_list(des_list):
    print('以下是复制好的列表：')
    for value in des_list:
        print(value)


# 调用函数
list1 = ['a', 'b', 'c', 'd']
list2 = []
carry(list1, list2)
show_des_list(list2)

# 8.4.2 禁止函数修改列表
# 用到了列表，但是不想让操作万函数后，这个列表被修改了，那么就可以用列表的副本，如：
list_3 = ['one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine', 'ten']
list_4 = []
carry(list_3[:], list_4)
show_des_list(list_3)
show_des_list(list_4)


# ===========================传递任意数量的实参=================================
# 8.5 传递任意数量的实参
def show_countries(*country):
    for value in country:
        print(value)


# 调用函数
show_countries('China')
show_countries('HK', 'USA', 'Japan')


# 8.5.1 结合使用 位置实参和任意数量实参
def show_cities(size, *name):
    print('--------------------')
    print('size = ' + str(size))
    for value in name:
        print(value)


show_cities(2, 'Pking')
show_cities(2)
show_cities(3, 'Tokyo', 'London', 'Milan')


# 8.5.2 使用 任意数量的关键字实参

def create_car(brand, country, **car_info):
    car = {}
    car['brand'] = brand
    car['country'] = country
    for key, value in car_info.items():
        car[key] = value
    return car


# 调用函数
car1 = create_car('Audi', 'Germany', price=100000, liter='95')
car2 = create_car('Honda', 'Japan', price=170000, liter='93')
print(car1)
print('------------------------------')
print(car2)

# ===========================将函数存储在模块中=================================
# 8.6 将函数存储在模块中
# 8.6.1 导入整个模块
# 创建模块：car_maker.py,里面有一个函数
from com.python.chapter8 import car_maker

car2 = car_maker.create_car('Benz','Germany',price=10)
print(car2)

# 8.6.2 导入特定的函数
from com.python.chapter8.car_maker import  create_car

car3 = create_car('Audi','Germany',price=20)
print(car3)

# 8.6.3 给函数指定别名 as
from com.python.chapter8.car_maker import create_car as cc
car4 = cc('Honda','Japan',price=30)
print(car4)

# 8.6.4 给模块指定别名 as
from com.python.chapter8 import car_maker as cm

car5 = cm.create_car('Buck','USA',price=40)
print(car5)

# 8.6.5 导入模块的所有函数 *
from com.python.chapter8.car_maker import *
hello()

