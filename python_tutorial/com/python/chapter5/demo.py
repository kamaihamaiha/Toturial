# 5-3 外星人颜色  -1 -2
alien_color = 'yellow'
if 'green' in alien_color:
    print('恭喜，你获取了 5 个点！')
else:
    print('抱歉，你杀死的外星人不值钱！')

# 5-4 外星人颜色 -3
if "green" in alien_color:
    print('恭喜，你获取了 5 个点！')
elif 'yellow' in alien_color:
    print('恭喜，你获取了 10 个点！')
elif 'red' in alien_color:
    print('恭喜，你获取了 15 个点！')

# 5-6 人生的不同阶段
print('5-6 人生的不同阶段')
age = -1;

if age < 2:
    print('婴儿')
elif age >= 2 and age < 4:
    print('正在蹒跚学步')
elif age >= 4 and age < 13:
    print('是儿童')
elif age >= 13 and age < 20:
    print('是青少年')
elif age >= 20 and age < 65:
    print('成年人')
else:
    print('日薄西山！')

# 5-7 喜欢的水果
print('5-7 喜欢的水果：')
favorite_fruits = ['banana','apple','orange','pear','lemon','watermelon']
if 'peach' in favorite_fruits:
    print('你喜欢吃桃！')
if 'apple' in favorite_fruits:
    print('你喜欢吃苹果')
if 'plum' in favorite_fruits:
    print('你喜欢吃李子')
if 'strawberry' in favorite_fruits:
    print('你喜欢吃草莓')
if 'cucumber' in favorite_fruits:
    print('你喜欢吃黄瓜')

# 5-8 以特殊的方式跟管理员打招呼
users = ['Alien','Blank','Cristin','Dennie','Emma','admin']
for user in users:
    if user == 'admin':
        print('你好，admin 想看下最近的统计情况吗？')
    else:
        print(' ' + user + '!')

# 5-9 处理没有用户的情形
if users:
    print('用户数：' + str(len(users)))
else:
    print('没有用户！')

# 删除列表的所有用户
del users[0:]
print('删除列表中的用户后：')
if users:
    print('用户数：' + str(len(users)))
else:
    print('没有用户！')

# 5-10 检查用户名
current_users = ['use1','user2','user3','user4','user5']
new_users= ['user3','user4','admin']
# 比较时，不区分字母大小写。用到了列表解析。
for new_user in new_users:
    if new_user.lower() in [current_user.lower for current_user in current_users]:
        print('请输入其他用户名！')
    else:
        print('该用户名没有被使用！')

# 5-11 序数
nums = range(1,10)
for num in nums:
    if num == 1 or num == 2 or num == 3:
        print(str(num) + 'st')
    else:
        print(str(num) + 'th')






