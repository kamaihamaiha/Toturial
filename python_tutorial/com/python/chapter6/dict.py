# 1.一个简单的字典
"""
存放外星人信息，这些外星人的颜色和点数各不相同。
ps: 有点像 Json 串
"""
alien_0 = {'color': 'green', 'points': 5}
print(alien_0['color'])
print(alien_0['points'])

# 2.添加键-值对
# 给外星人添加坐标
alien_0['x_position'] = 0
alien_0['y_position'] = 100
print(alien_0)

# 3.定义空的字典
alien_1 = {}

# 4.修改字典中的值
alien_1['name'] = '小强'
alien_1['age'] = 22
print(alien_1)
print('修改年龄后：')
alien_1['age'] = 12
print(alien_1)

# 5.删除键值对
# 用 del 语句
nums = {'one': 1, 'tow': 2, 'three': 3, 'four': 4, 'six': 6}
print(nums)
print('删除键值对')
del nums['six']
print(nums)

# 6.字典多行的定义方式
countries = {
    'China': 'Asian',
    'Japan': 'Asian',
    'America': 'North America',
    'British': 'Europe',
    'Brazil': 'South America'
}
print(countries)

# 7.遍历字典
football_players = {
    'Messi': 10,
    'Cristiano': 7,
    'Neymar': 10,
    'Bale': 11,
    'Pogba': 6,
}
# 7.0
for key, value in football_players.items():
    print('\n球员: ' + key)
    print('球衣号: ' + str(value))

# 7.1 遍历字典的所有键
for key in football_players.keys():
    print('球员： ' + key)
print('***********************')
# 7.2 也可以这样，其实默认就是遍历的键
for key in football_players:
    print('球员： ' + key)
print('***********************')

# 7.3 按顺序遍历字典的所有键
for key in sorted(football_players.keys()):
    print('球员： ' + key)
print('***********************')

# 7.4 遍历字典的所有值
for value in football_players.values():
    print('球衣号： ' + str(value))
print('***********************')

# 7.4 遍历字典的所有值-去重
for value in set(football_players.values()):
    print('球衣号： ' + str(value))
print('***********************')

# 8 嵌套
# 把字典存到列表中，或者把列表存到字典中

# 8.1 字典存到列表
player0 = {'name': '刘翔', 'career': '110米栏', 'age': 22, 'nationality': 'China'}
player1 = {'name': '孙杨', 'career': '有用', 'age': 20, 'nationality': 'China'}
player2 = {'name': '姚明', 'career': '篮球', 'age': 32, 'nationality': 'China'}

# 把字典存放到列表中
famous_players = [player0, player1, player2]
for player in famous_players:
    print(player)

# 批量添加运动员
for num in range(1, 10):
    new_player = {'name': '二级运动员', 'career': '运动员', 'age': 22, 'nationality': '中国'}
    famous_players.append(new_player)

for player in famous_players:
    print(player)

# 8.2 列表存到字典中
print('******************列表存到字典中')
provinces = {
    'name': '山东',
    'cities': ['济南', '青岛', '烟台', '威海', '潍坊', '淄博', '临沂', '东营', '日照'],
}
for key, value in provinces.items():
    if key == 'name':
        print(value + '省的城市有：')
    else:
        for city in value:
            print(city)

# 8.2 字典中存放字典
print('*******************字典中存放字典')
football_clubs = {
    'Real Madrid': {
        'city': 'Madrid',
        'Home Field': 'Bernabeu',
        'league': 'La Liga',
    },
    'AC Milan': {
        'city': 'Milan',
        'Home Field': 'San Siro',
        'league': 'Serie A',
    },
    'Liverpool': {
        'city': 'Liverpool',
        'Home Field': 'Anfield Stadium',
        'league': 'Premier League',
    },
}

for club,club_info in football_clubs.items():
    print('\n'+club)
    print(club_info['city'])
    print(club_info['Home Field'])
    print(club_info['league'])
