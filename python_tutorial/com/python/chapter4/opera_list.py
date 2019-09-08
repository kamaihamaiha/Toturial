# 4.1 遍历整个列表
laptops = ['ThinkPad','Mac','Dell','HP','Sony','Samsung','Lenovo']
for laptop in laptops:
    print(laptop)

# 4.1.2 在 for 循环中执行更多的操作
for laptop in laptops:
    print(laptop + " 是个不错的电脑！")
    print('------------------------')
print("所有的电脑我都看了一遍！")

# 4.3 创建数值列表

# 4.3.1 使用函数 range()
# 生成一系列数字
for value in range(1,11):
    print(value)

# 4.3.1 使用函数 range() 创建数字列表, 用 list() 把 range() 的结果转换为列表
numbers = list(range(1,11))
print(numbers)

# range() 函数可以指定步长，如得到一个 1-10 的偶数列表
even_numbers = list(range(2,11,2))
print(even_numbers)

# 把 1-10 的数的平方加到列表中 - 0
squares = []
for value in list(range(1,11)):
    squares.append(value * value)

print(squares)

# 4.3.3 对数字列表执行简单的统计计算
digits = [3,1,4,1,5,9,2,6,5,3,5,8,9,7]
print('digits 的最大元素是：' + str(max(digits)))
print('digits 的最小元素是：' + str(min(digits)))
print('digits 的和是：' + str(sum(digits)))

# 4.3.4 列表解析
# 把 1-10 的数的平方加到列表中 - 1
squares1 = [value ** 2 for value in range(1,11)]
print(squares1)

# 4.4 使用列表的一部分
# 4.4.1 切片
last_names = ['赵','钱','孙','李','周','吴','郑','王','冯','陈']

print('截取索引为 1-(3-1) 的片段')
print(last_names[1:3])

print('截取索引 2 到最后一个索引的片段')
print(last_names[2:])

print('截取前 5 个索引的片段')
print(last_names[:5])

print('截取最后 2 个索引片段')
print(last_names[-2:])

# 4.4.2  遍历切片
# 依然使用上面定义的列表
print('遍历列表的前 5 个元素')
for value in last_names[:5]:
    print(value)

# 4.4.3  复制列表
foods1 = ['花生','牛奶','土豆','丝瓜']
# 开始复制
foods2 = foods1[:]
print(foods2)

# 注意下面的方式不是复制，此时 foods3 和 foods1 其实是一个变量了。
foods3 = foods1
print(foods3)
foods1.append('冬瓜')
print(foods3)

# 4.5 元组 - 不可修改的列表
weeks = ('Monday','Tuesday','Wednesday','Thursday','Friday','Saturday','Sunday')
print(weeks)
print('-------------------------------遍历元组')
for week in weeks:
    print(week)
# 4.5.3 修改元组变量
weeks = ('周一','周二','周三','周四','周五','周六','周天')
print(weeks)



