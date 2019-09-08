# 7-1 租赁汽车
cars = ['Audi','Benz','Ford','Honda','Toyota','Nissan','BMW','Mini','Smart','Subaru','Volkswagen','Volvo','Tesl'
    ,'Porsche','Mazda','Ferrari','Mitsubishi']

request_car = input('请问您要租赁什么牌子的汽车？\n')
# 查找本地是否有这个汽车，品牌名不分大小写
if request_car.lower() in [car.lower() for car in cars]:
    print('给你一辆 ' + request_car)
else:
    print('对不起，我们这没有 ' + request_car + '!')

# 7-2 餐馆定位
restaurant_room = input('请问，几位？\n')
restaurant_room = int(restaurant_room)
if restaurant_room > 8:
    print('对不起，没有空桌了！')
else:
    print('请跟我来！')

# 7-3 10 的整数倍
num = input('请输入一个 10 的整数倍的数： ')
num = int(num)
if num % 10 == 0:
    print('Good!')
else:
    print('Wrong!')

# 7-4 菜煎饼配料
prompt_pans = '请选择菜煎饼的配料，选完后输入 exit 结束：\n'
print(prompt_pans)
pans_toppings = []
topping = ''
while True:
    topping = input(topping)
    if topping == 'exit':
        break
    pans_toppings.append(topping)

print('你选的配料是：')
for pans_topping in  pans_toppings:
    if pans_topping != '':
        print(pans_topping)

# 7-5 电影票
age_prompt = '\n购买电影票，请输入你的年龄：\n'
age_prompt += '输入 -1 结束\n'
while True:
    # 这个 input() 很重要，因为只有调用了此函数，才能等待。否则就一直死循环了！
    age = input(age_prompt)
    age = int(age)
    if age == -1:
        break
    elif age <= 3:
        print('票价： 5￥')
    elif age <= 10:
        print('票价： 10￥')
    elif age <= 18:
        print('票价： 15￥')
    else:
        print('票价： 20￥')

# 7-6 三个出口
# 7-4 菜煎饼配料
prompt_pans = '请选择菜煎饼的配料，选完后输入 exit 结束：'
print(prompt_pans)
pans_toppings = []
topping = ''
# --------------------------------------------------------------------------------------------
# 条件测试方式循环
print('*************出口1： 条件测试方式循环')
while topping != 'exit':
    topping = input(topping)
    pans_toppings.append(topping)

print('你选的配料是：')
for pans_topping in pans_toppings:
    if pans_topping != '':
        if pans_topping != 'exit':
            print(pans_topping)

# --------------------------------------------------------------------------------------------
# 变量控制 方式循环
print('*************出口2： 变量控制 方式循环')
del pans_toppings[:]
topping = ''
active = True
while active:
    topping = input(topping)
    if topping == 'exit':
        active = False
    pans_toppings.append(topping)

print('你选的配料是：')
for pans_topping in pans_toppings:
    if pans_topping != '':
        if pans_topping != 'exit':
            print(pans_topping)


# --------------------------------------------------------------------------------------------
# break 控制方式循环
print('*************出口3： break 控制方式循环')
del pans_toppings[:]
topping = ''
while True:
    topping = input(topping)
    if topping == 'exit':
        break
    pans_toppings.append(topping)

print('你选的配料是：')
for pans_topping in pans_toppings:
    if pans_topping != '':
            print(pans_topping)

print('三个出口： 电影票')

# ==============================================================================================

# 7-5 电影票
age_prompt = '\n购买电影票，请输入你的年龄：\n'
age_prompt += '输入 -1 结束\n'
# --------------------------------------------------------------------------------------------
print('出口1： 条件测试')
age = 0
while age != -1:
    age = input(age_prompt)
    age = int(age)
    if age == -1:
        break
    elif age <= 3:
        print('票价： 5￥')
    elif age <= 10:
        print('票价： 10￥')
    elif age <= 18:
        print('票价： 15￥')
    else:
        print('票价： 20￥')

# --------------------------------------------------------------------------------------------
print('出口2： 变量控制')
age = 0
active = True
while active:
    age = input(age_prompt)
    age = int(age)
    if age == -1:
        active = False
    if age == -1:
        break
    elif age <= 3:
        print('票价： 5￥')
    elif age <= 10:
        print('票价： 10￥')
    elif age <= 18:
        print('票价： 15￥')
    else:
        print('票价： 20￥')

# --------------------------------------------------------------------------------------------
print('出口3： break 语句')
age = 0
while True:
    # 这个 input() 很重要，因为只有调用了此函数，才能等待。否则就一直死循环了！
    age = input(age_prompt)
    age = int(age)
    if age == -1:
        break
    elif age <= 3:
        print('票价： 5￥')
    elif age <= 10:
        print('票价： 10￥')
    elif age <= 18:
        print('票价： 15￥')
    else:
        print('票价： 20￥')
# ==============================================================================================
# 7-8 熟食店
sandwich_orders = ['三明治1','三明治2','三明治3']
finished_sandwiches = []
while sandwich_orders:
    cur_sandwich = sandwich_orders.pop()
    print(cur_sandwich)

    finished_sandwiches.append(cur_sandwich)

print('三明治都制作好了！')
for value in finished_sandwiches:
    print(value)

# --------------------------------------------------------------------------------------------
# 7-9 五香烟熏牛肉
print('五香烟熏牛肉卖完了！')
sandwich_orders.append('pastrami')
sandwich_orders.append('pastrami')
sandwich_orders.append('pastrami')
sandwich_orders.append('pastrami')
while 'pastrami' in sandwich_orders:
    sandwich_orders.remove('pastrami')

if 'pastrami' in finished_sandwiches:
    print('最终列表包含 pastrami')
else:
    print('最终列表不包含 pastrami')

# --------------------------------------------------------------------------------------------
# 7-10 梦想的度假胜地
print('你梦想的度假胜地是那里？')
visits = {}
while True:
    name = input('请输入你的名字：\n')
    visit = input('请输入你想去的地方：\n')

    visits[name] = visit;

    next_person = input('请下一位： yes/no?')
    if next_person == 'no':
        break
    elif next_person == 'yes':
        continue
    else:
        print('输入错误！没有： ' + next_person)

for name,visit in visits.items():
    print(name + ' 想去： ' + visit)
