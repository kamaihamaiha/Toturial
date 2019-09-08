# if 语句
# 5.1 打印汽车名称
cars = ['audi', 'benz', 'bmw', 'honda']
for car in cars:
    if car == 'bmw':
        print(car.upper())
    else:
        print(car.title())

# 5.2 多个判断
age = 8
if age > 18 and age < 30:
    print('是年轻人！')
else:
    if age >= 30:
        print('人生阅历丰富！')
    else:
        print('祖国的花朵')

if age > 60 or age < 10:
    print('给你让座！')
else:
    print('还是站着吧！')

# 5.2.6 检查特定值是否包含在列表中，用 in
if 'toyota' in cars:
    print('丰田在里面！')
else:
    print('丰田不再里面！')

# 5.2.7 检查特定值是否 不包含在列表中，用 not in
river_crabs = ['江蛤蟆', '习包子', '中国影帝', '六四', '法轮功']
search_key1 = '滴滴'
search_key2 = '六四'
if search_key1 not in river_crabs:
    print('你是个良民，可以继续上网了！')
else:
    print('你的，良心大大的坏了！')

if search_key2 not in river_crabs:
    print('你是个良民，可以继续上网了！')
else:
    print('你的，良心大大的坏了！')
    print('很快就有人找你喝茶！')

# 5.2.8 布尔表达式
ok = True
no = False

# 5.3.2 if-elif-else 语句
# 判断结果超过 2 个的情况下使用
assets = 90000000;
if assets < 20000:
    print('赤贫！')
elif assets < 100000:
    print('穷人')
elif assets >= 100000 and assets < 1000000:
    print('小康')
elif assets >= 1000000 and assets < 10000000:
    print('富裕')
else:
    print('有钱！')

# 判断多个条件，都用 if
resume = ['30岁', '硕士', '180cm', '30k']
if '30岁' in resume:
    print('年轻！')
if '硕士' in resume:
    print('高学历')
if '180cm' in resume:
    print('魁梧')
if '30k' in resume:
    print('高收入！')

# 5.4.1 检查特殊元素,比如 茄子没有了。
# 顾客的购物清单
vegetables = ['土豆', '黄瓜', '西红柿', '茄子', '豆芽', '蒜苗', '粉条']
for value in vegetables:
    if value == '茄子':
        print('抱歉，茄子卖光了！')
    else:
        print('给你一个: ' + value)

# 5.4.2 检查列表是否是空的
print('5.4.2 检查列表是否是空的:')
wallets = [1, 2, 5, 20]
if wallets:
    print('有点钱！')
else:
    print('见不到孔方兄！')

# 5.4.3 使用多个列表
clothes = ['袜子', '鞋', '裤子', '衬衫', '领带', '内裤', '帽子', '围巾']
customer_requests = ['鞋', '围巾', '貂皮大衣']
# 判断是否能满足顾客要求
for customer_request in customer_requests:
    if customer_request in clothes:
        print('给你挑选了一个： ' + customer_request)
    else:
        print('抱歉，本小店没有：' + customer_request)
