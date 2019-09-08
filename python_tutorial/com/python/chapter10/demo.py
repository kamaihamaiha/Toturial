# 动手试一试
# 10-1 Python 学习笔记
file_name = '/home/kk/PycharmProjects/python_tutorial/com/python/chapter10/file/learning_python.txt'

print('++++++++++++++++++++ 第一次打印，读取整个文件')
with open(file_name) as file_object:
    content = file_object.read()
    print(content)

print('++++++++++++++++++++ 第二次打印，遍历文件对象')
with open(file_name) as file_object:
    for value in file_object:
        print(value.strip())

print('++++++++++++++++++++ 第三次打印，把各行存到列表中，在 with 代码块外打印')
with open(file_name) as file_object:
    lines = file_object.readlines()

for line in lines:
    print(line.strip())

# 10-2 C 语言学习笔记
print('++++++++++++++++++++ C 语言学习笔记')
with open(file_name) as file_object:
    lines = file_object.readlines()

for line in lines:
    new_line = line.replace('Python', 'C')
    print(new_line.strip())

# 10-3 访客：编写一个程序，提示用户输入其名字；用户做出响应后，将其名字写入到文件 guest.txt 中。
print('++++++++++++++++++++ 10-3 访客')
user_name = input('Please input your name: ')
user_info_file = 'guest.txt'
with open(user_info_file, 'w') as file_object:
    file_object.write(user_name)

# 10-4 访客名单：编写一个 while 循环，提示用户输入其名字。用户输入名字后，在屏幕上打印一句问候语，并将一条访问记录添加到文件 guest_book.txt。
print('++++++++++++++++++++ 10-4 访客名单')

guest_file_name = 'guest_book.txt'
user_name = ''
while True:
    user_name = input('请输入名字： ')
    print('按 "q" 键退出！')
    if user_name == 'q':
        break
    else:
        with open(guest_file_name, 'a') as file_object:
            file_object.write(user_name + '\n')

# 10-5 关于编程的调查： 编写一个 while 循环，询问用户为何喜欢编程。每当用户输入一个原因后，就添加到一个文件中。
coding_reason_file = 'coding_reason.txt'
coding_reason = ''
while True:
    coding_reason = input('你为何喜欢编程？')
    print('按下 "q" 退出')
    if coding_reason == 'q':
        break
    else:
        with open(coding_reason_file, 'a') as file_object:
            file_object.write(coding_reason + '\n')

# 10-6 加法运算： 提示用户输入数值，并且在用户输入不是数字时给出提示。+ 10-7 加法计算器
print('+++++++++++++++++++++++++++ 10-6 加法运算：')

print("Give me two numbers, and I'll divide them.")
print("Enter '-1' to quit.")

while True:
    try:
        first_number = input('\nFirstNumber: ')
        first_number = int(first_number)
        if first_number == -1:
            break
        second_number = input('\nSecondNumber: ')
        second_number = int(second_number)
        if second_number == -1:
            break
    except ValueError:
        print('input error: not a value!')
    else:
        answer = first_number + second_number
        print(str(first_number) + ' + ' + str(second_number) + ' = ' + str(answer))

# 10-8 猫和狗： 创建两个文件 cats.txt 和 dogs.txt，都存上至少三个名字。然后读取这两个文件，且能有容错功能。
# 10-9 沉默的猫和狗
print('++++++++++++++++++++++++ 猫和狗：')
cat_file = '/home/kk/PycharmProjects/python_tutorial/com/python/chapter10/except_/cats.txt'
dog_file = 'dogs.txt'

"""定义一个方法，可以读取宠物文件"""


def read_pet(file_name):
    try:
        with open(file_name) as file_obj:
            contents = file_obj.read()
    except FileNotFoundError:
        pass
        # print('The file: ' + file_name + ' does not exits!')
    else:
        print(contents.strip())

# 调用方法
read_pet(cat_file)
read_pet(dog_file)

# 10-10 常见单词： 统计文本文件中，某个单词出现的次数
print('+++++++++++++++++++++++++ 10-10 常见单词： 统计文本文件中，某个单词出现的次数')
# 统计 /file/pi_million_digits.txt 中 9 出现的次数
pi_file = '/home/kk/PycharmProjects/python_tutorial/com/python/chapter10/file/pi_million_digits.txt'

try:
    with open(pi_file) as file_obj:
        contents = file_obj.read()
except FileNotFoundError:
    print('文件： ' + pi_file + ' 没有找到！')
else:
    count = contents.count('9')
    print('文件： '+ pi_file + ' 中，"9" 出现了： ' + str(count) + ' 次。')

# 10-11 喜欢的数字： 提示用户输入他喜欢的数字，并使用 json.dump() 把数字存储到文件中，再编写一个程序，从文件中读取这个值，并打印出来。
# 见： /data/luck_number.py 和 /data/read_luck_number.py

# 10-12 记住喜欢的数字： 把上面练习的两个程序合二为一
# 见： /data/opera_number.py

# 10-13 验证用户： 打印欢迎用户回来消息前，验证用户名是否正确
# 见： /data/remember_me.py
