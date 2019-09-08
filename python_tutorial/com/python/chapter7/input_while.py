message = input('输入任何内容，我会原样输出！\n')
print(message)

# 7.1.1 编写清晰的程序
name = input('请输入你的名字： ')
print('你好， ' + name + '!')

# 7.1.2 使用 int() 来获取数值输入
age = input('你多大了？ ')
age = int(age)
if age < 18:
    print('你好年轻！')
else:
    print('你长大了！')

# 7.1.3 求模运算符 - %
num = input('请输入一个数字，我会判断奇偶性： ')
num = int(num)
if num % 2 == 0:
    print('你输入的是偶数！')
else:
    print('你输入的是奇数！')

# 7.2 while
print('###################### while 循环 #####################')

# 7.2.1
cur_num = 1
while cur_num <= 5:
    print(cur_num)
    cur_num += 1

# 7.2.2 让用户选择何时退出
print('************** 让用户选择何时退出 ***********')
prompt = '随便输入，我会原样输出：'
prompt += '\n输入 "exit" 退出。'
print(prompt)
msg = ''
while msg != 'exit':
    msg = input(msg)
    if msg != 'exit':
        print(msg)

print('成功退出！')

# 7.2.3 使用标记，其实就是使用布尔型变量控制循环
print('************** 让用户选择何时退出-使用标记 ***********')
prompt = '随便输入，我会原样输出：'
prompt += '\n输入 "exit" 退出。'
print(prompt)
msg2 = ''
active = True
while active:
    msg2 = input(msg2)
    if msg2 == 'exit':
        active = False
    else:
        print(msg2)
print('成功退出！')

# 7.2.4 使用 break 退出循环
print('************** 让用户选择何时退出-使用 break ***********')
prompt = '随便输入，我会原样输出：'
prompt += '\n输入 "exit" 退出。'
print(prompt)
msg3 = ''
while True:
    msg3 = input(msg3)
    if msg3 == 'exit':
        break
    else:
        print(msg3)
print('成功退出！')

# 7.2.5 使用 continue
print('************** 打印 10 以内的奇数，用 continue')
cur_num = 0
while cur_num < 10:
    cur_num += 1
    if cur_num % 2 == 0:
        continue

    print(cur_num)

# ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

# 用 while 处理列表和字典

# 7.3.1 在列表之间移动元素
old_users = ['a', 'b', 'c', 'd']
new_users = []
while old_users:
    cur_user = old_users.pop()
    print('正在处理的用户： ' + cur_user)
    new_users.append(cur_user)

print('所有用户已移动完成！')
for user in new_users:
    print(user)

# ++++++++++++++++++++++++++++++++++++++
# 7.3.2 删除列表中特定值的所有元素
# 删除 cat
pets = ['dog', 'cat', 'fish', 'rabbit', 'pig', 'cat', 'cat']
while 'cat' in pets:
    pets.remove('cat')

print(pets)

# ++++++++++++++++++++++++++++++++++++++
# 7.3.3 让用户输入来填充字典
active = True
students = {}
while active:
    name = input('请输入名字：\n')
    age = input('请输入年龄：\n')
    age = int(age)

    students[name] = age

    repeat = input('继续下一个？ yes/no\n')
    if repeat == 'no':
        active = False

print('统计完成！')
for name, age in students.items():
    print(name + ',年龄： ' + str(age))
