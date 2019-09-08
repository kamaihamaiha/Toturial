# 10.1.1 读取整个文件
print('+++++++++++++++++++ 读取该模块所在目录下的文件 pi_digits.txt 的内容')
with open('pi_digits.txt') as file_object:
    contents = file_object.read()
    print(contents)

# 10.1.2 读取文件，根据路径
print('+++++++++++++++++++ 读取该模块所在目录下的 /file/ 中的文件 poet.txt 的内容')
# 用的绝对路径，文件路径分隔符在 Linux 和 OS X 中用 / ,在 Windows 用 \ 。
with open('/home/kk/PycharmProjects/python_tutorial/com/python/chapter10/file/poet.txt') as file_object:
    contents = file_object.read()
    print(contents)

# 10.1.3 逐行读取
print('+++++++++++++++++++ 逐行读取')
file_name = '/home/kk/PycharmProjects/python_tutorial/com/python/chapter10/file/poet.txt'

with open(file_name) as file_object:
    for line in file_object:
        print(line.rstrip())  # rstrip()为了去掉多余的空白行

# 10.1.4 把文件的每一行存到列表中
print('+++++++++++++++++++ 把文件的每一行存到列表中')
with open(file_name) as file_object:
    lines = file_object.readlines()

# 打印 lines 内容
for line in lines:
    print(line.strip())

# 10.1.5 使用文件内容
print('+++++++++++++++++++ 使用文件内容')
# 把 pi_digits.txt 的内容读出来，以字符串保存，然后打印出来

with open('pi_digits.txt') as file_object:
    lines = file_object.readlines()

pi_string = ''
for line in lines:
    pi_string += line.strip()

print(pi_string)
print('数字长度： ' + str(len(pi_string)))

# 10.1.6 读大文件
print('+++++++++++++++++++ 读大文件')
big_file = '/home/kk/PycharmProjects/python_tutorial/com/python/chapter10/file/pi_million_digits.txt'

with open(big_file) as file_object:
    lines = file_object.readlines()

big_pi_string = ''
for line in lines:
    big_pi_string += line

print(big_pi_string[:30] + '...')
print('数字长度： ' + str(len(big_pi_string)))

# 10.1.7 圆周率中是否包含你的生日
print('+++++++++++++++++++ 圆周率中是否包含你的生日')

# 继续使用上面的 big_pi_string

birth_day = input('请输入你的生日，格式为：年月日')
if birth_day in big_pi_string:
    print('找到了！')
else:
    print('找不到！')

