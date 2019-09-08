# 10.2.1 写入空文件

"""往文件 programming.txt 写入，参数： 'w' 是告诉 Python 以写入模式打开文件。
其他模式： 读取模式 > 'r' , 附加模式 > 'a' , 读取和写入模式 > 'r+' """
file_name = 'programming.txt'

with open(file_name,'w') as file_object:
    file_object.write('I love programming.')

"""注意：当以 'w' 模式打开文件时，没有文件就自动创建一个。如果有了该文件，就在返回文件对象前清空该文件。"""
"""注意：Python 只能将字符串写入文本文件。"""

# 10.2.2 写入多行
"""函数 wirte() 不会自动在文本末尾添加换行符，所以如果写入多行，就加上换行符： '\n' """
with open(file_name,'w') as file_object:
    file_object.write('I love programming.\n')
    file_object.write('I like playing football!\n')

# 10.2.3 附加到文件
with open(file_name,'a') as file_object:
    file_object.write('我喜欢玩赛车游戏！\n')
    file_object.write('我喜欢电子产品！\n')

