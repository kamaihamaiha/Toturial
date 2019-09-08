# 3-1 姓名
names = ['赵四', "钱学森", "孙悟空", "李寻欢", "Tomas"]
print(names[0])
print(names[1])
print(names[2])
print(names[3])
print(names[4])

# 3-2 问候语
hello = "，你好啊！"
print(names[0] + hello)
print(names[1] + hello)
print(names[2] + hello)
print(names[3] + hello)
print(names[4] + hello)

# 3-3 自己的列表
fruits = ['apple', 'pear', 'orange', 'banana', 'mangosteen']
print('我喜欢吃：' + fruits[0])
print('我喜欢吃：' + fruits[1])
print('我喜欢吃：' + fruits[2])
print('我喜欢吃：' + fruits[3])
print('我喜欢吃：' + fruits[4])

# 3-4  嘉宾名单
guests = ['秦始皇', '西施', '貂蝉', '吕布']
print('邀请' + guests[0] + "吃晚饭！")
print('邀请' + guests[1] + "吃晚饭！")
print('邀请' + guests[2] + "吃晚饭！")
print('邀请' + guests[3] + "吃晚饭！")

# 3-5 修改嘉宾名单那
print(guests[0] + "无法赴约！")
del guests[0]
guests.insert(0, '项羽')
print('邀请' + guests[0] + "吃晚饭！")
print('邀请' + guests[1] + "吃晚饭！")
print('邀请' + guests[2] + "吃晚饭！")
print('邀请' + guests[3] + "吃晚饭！")

# 3-6 添加嘉宾
print("我找到了更大的桌子，可以请更多的人来吃饭了！")
guests.insert(0, '刘邦')
guests.insert(3, '张良')
guests.append('韩信')
print('--------------------大桌-------------')
print('邀请' + guests[0] + "吃晚饭！")
print('邀请' + guests[1] + "吃晚饭！")
print('邀请' + guests[2] + "吃晚饭！")
print('邀请' + guests[3] + "吃晚饭！")
print('邀请' + guests[4] + "吃晚饭！")
print('邀请' + guests[5] + "吃晚饭！")
print('邀请' + guests[6] + "吃晚饭！")

# 3-7 缩减名单
print('抱歉各位！刚接到中央下方的文件，要缩减开支，所以只能邀请 2 位了！')
print('很抱歉，' + guests.pop() + "! 下次再请你！")
print('很抱歉，' + guests.pop() + "! 下次再请你！")
print('很抱歉，' + guests.pop() + "! 下次再请你！")
print('很抱歉，' + guests.pop() + "! 下次再请你！")
print('很抱歉，' + guests.pop() + "! 下次再请你！")

print("恭喜" + guests[0] + "你可以敞开吃了！")
print("恭喜" + guests[1] + "你可以敞开吃了！")

del guests[1]
del guests[0]

print(guests)

# 3-8 放眼看世界
print('==============放眼看世界=================')
directs = ['Shanghai', 'HK', 'Africa', 'Amazon Rain Forest', 'Alps']

# 原版打印
print('-----------------原版打印')
print(directs)
# 临时排序打印
print('-----------------临时排序打印')
print(sorted(directs))
# 核实，临时排序是否改变了顺序
print('-----------------核实，临时排序是否改变了顺序')
print(directs)
# 临时排序[倒序]打印
print('-----------------临时排序[倒序]打印')
print(sorted(directs, reverse=True))
# 核实，临时排序[倒序]是否改变了顺序
print('-----------------核实，临时排序[倒序]是否改变了顺序')
print(directs)
# 倒着打印
print('-----------------倒着打印')
directs.reverse()
print(directs)
# 再倒一次打印
print('-----------------再倒一次打印')
directs.reverse()
print(directs)

# 排序后打印
print('-----------------排序后打印')
directs.sort()
print(directs)
# 排倒序后打印
print('-----------------排倒序后打印')
directs.sort(reverse=True)
print(directs)

# 3.9 晚餐嘉宾
print('----------------------------------统计邀请嘉宾人数：')
print('邀请人数：' + str(len(guests)))
