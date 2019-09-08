# 6-1 人
person = {
    'name': '孙兴民',
    'age': 26,
    'height': 186,
    'career': '足球运动员',
    'nationality': 'South Korean'
}
print(person['name'])
print(person['age'])
print(person['height'])
print(person['career'])
print(person['nationality'])

# 6-2 喜欢的数字
lucky_nums = {
    'Messi': 10,
    'Cristiano': 7,
    'Neymar': 10,
    'Bale': 11,
    'Pogba': 6,
}
for lucky_num in lucky_nums:
    print(lucky_num + ' 的球衣号码是： ' + str(lucky_nums[lucky_num]) + '号')
print('*************************')
# 6-3 词汇表
print('编程词汇')
vocabularies = {
    'Python': '蟒蛇',
    'pop': '删除并返回',
    'insert': '插入元素',
    'sort': '排序',
    'range': '按范围取值',
}

print('Python: '+vocabularies['Python'])
print('pop: '+vocabularies['pop'])
print('insert: '+vocabularies['insert'])
print('sort: '+vocabularies['sort'])
print('range: '+vocabularies['range'])

# 6-4 词汇表2
print('***********************遍历输出')
for key,value in vocabularies.items():
    print(key + ':\t' + value)

# 再添加 5 个 Python 术语
vocabularies['if'] = '如果'
vocabularies['else'] = '否则'
vocabularies['key'] = '键'
vocabularies['value'] = '值'
vocabularies['del'] = '删除'
print('***********************遍历输出[添加5个 Python 术语后]:')
for key,value in vocabularies.items():
    print(key + ':\t' + value)

# 6-5 河流
print('***************** 6-5 河流：')
rivers = {
    'Nile': 'Egypt',
    'Yangtze River': 'China',
    'Amazon River': 'Brazil',
    'Mississippi River': 'America',
    'Danube River': 'Germany',
}
for key,value in rivers.items():
    print('The ' + key + ' runs through ' + value + '.')

# 6-6 调查
print('6-6 调查')
players = ['Bale','Messi','kk','Kane']
for player in players:
    if player in lucky_nums.keys():
        print(player + ' 谢谢配合！')
    else:
        print(player + ' 请参与我们的调查！')

# 6-7 人
print('*****************人')
person1 = {
    'name': '凯恩',
    'age': 28,
    'height': 182,
    'career': '足球运动员',
    'nationality': 'UK'
}
person2 = {
    'name': '武磊',
    'age': 29,
    'height': 179,
    'career': '足球运动员',
    'nationality': 'China'
}
people = [person,person1,person2]
for value in people:
    print('\n姓名：' + value['name'])
    print('\t年龄： ' + str(value['age']))
    print('\t身高： ' + str(value['height']))
    print('\t职业： ' + value['career'])
    print('\t国籍： ' + value['nationality'])

# 6-8 宠物
print('**************宠物')
dog = {'kinds': '警犬','master': '张三'}
cat = {'kinds': '波斯猫','master': '阿三'}
rabbit = {'kinds': '长毛兔','master': '李四'}
pets = [dog,cat,rabbit]

for pet in pets:
    print(pet['kinds'] + ': ' + pet['master'])

# 6-9 喜欢的地方
print('******************喜欢的地方')
favorite_places = {}
favorite_places['Ali'] = ['HK','Tokyo']
favorite_places['Bell'] = ['London','NewYork']
favorite_places['Cristin'] = ['Paris','Milan','Peking']

for key,value in favorite_places.items():
    print('\n' + key +' 喜欢的地方：')
    for place in value:
        print(place)

# 6-10 喜欢的数字
print('**************喜欢的数字2')
new_luck_nums = {}
new_luck_nums['Messi'] = [10,9,8]
new_luck_nums['Cristiano'] = [7,6]
new_luck_nums['Neymar'] = [10,13,8]
new_luck_nums['Bale'] = [11,12,20]
new_luck_nums['Pogba'] = [6,5,11]

for name,info in new_luck_nums.items():
    print('\n' + name + ' 喜欢的数字：')
    for value in info:
        print(value)

# 6-11 城市
cities = {}
hk = {
    'country': 'China',
    'population': 7000000,
    'fact': '金融中心',
}

london = {
    'country': 'UK',
    'population': 8000000,
    'fact': '金融中心',
}

tokyo = {
    'country': 'Japan',
    'population': 17000000,
    'fact': '金融中心',
}

cities['HK'] = hk
cities['London'] = london
cities['Tokyo'] = tokyo

for key,value in cities.items():
    print('\n' + key + ":")
    print('\t' + value['country'])
    print('\t' + str(value['population']))
    print('\t' + value['fact'])