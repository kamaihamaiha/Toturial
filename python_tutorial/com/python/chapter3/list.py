# 1.列表：由一系列按特定顺序排列的元素组成
bicycles = ['自行车1号', '自行车2号', '自行车3号']
print(bicycles)

nums = [3, 1, 4, 1, 5, 9, 2, 6]
print(nums)

# 2.访问列表的元素
print(bicycles[1])

# 3.访问列表的最后一个元素
print(bicycles[-1])
print(nums[-1])

message = "我的第一辆自行车是：" + bicycles[0]
print(message)

# 4.修改列表元素
bicycles[0] = 'Honda'
bicycles[2] = 'Suzuki'
print(bicycles)

# 5.添加元素-在末尾
bicycles.append('Yamaha')
print(bicycles)

# 6.插入元素
bicycles.insert(4, 'ducati')
bicycles.insert(0, '毛驴')
print(bicycles)

# 7.删除，用的是 del 语句，而不是方法！
del bicycles[2]
print(bicycles)

# 8.获取弹出的元素,默认是最后一个
del_bicycle = bicycles.pop();
print(bicycles)
print("刚删除的摩托车是：" + del_bicycle)

# 9.弹出列表中任意位置的元素
some_bicycle = bicycles.pop(0)
print(bicycles)
print("刚弹出的摩托车是：" + some_bicycle)

# 10.根据值删除元素，remove。只删除第一个指定的值
bicycles.remove("Honda")
print(bicycles)

"""
----------------------------------------------------以下是组织列表-----------------------
"""

# 3.3.1 使用 sort() 方法对列表进行永久排序
cars = ['bmw', 'toyota', 'audi', 'volvo']
cars.sort()
print(cars)

# 反序排列
cars.sort(reverse=True)
print(cars)

#  函数 sorted() 临时排序
cars2 = ['bmw', 'toyota', 'audi', 'volvo']
print(sorted(cars2))
print(sorted(cars2,reverse=True))

#  3.3.3 倒着打印列表，reverse()
poie = ['白','日','依','山','近']
poie.reverse()
print(poie)

# 3.3.4 确定列表长度，函数 len()
print("poie 长度：" + str(len(poie)))

