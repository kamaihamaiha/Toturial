# 4-1 面条
noodles = ['炸酱面','鸡丝面','鸡蛋面','牛肉面',]
for noodle in noodles:
    print('我喜欢吃 ' + noodle)
print("----------------吃完了！")

# 4-2 动物
animals = ['chicken','duck','goose','pig','ox','horse','donkey']
for animal in animals:
    print(animal + " 肉好吃！")
print('这些动物的肉都很美味！')

print('===========================')

# 4-3 数到 20
for value in range(1,21):
    print(value)

# 4-4 一百万
nums_million = [value for value in range(1,1000001)]
for num_million in nums_million:
    break
print(num_million)
# 4-5 计算 1-1000 000  的总和
millions = list(range(1,1000001))
print('最小值：' + str(min(millions)))
print('最大值：' + str(max(millions)))
print('和：' + str(sum(millions)))

# 4-3 奇数
odds = list(range(1,21,2))
for odd in odds:
    print(odd)

# 4-4 3 的倍数
three_times_nums = list(range(3,31,3))
for three_times_num in three_times_nums:
    print(three_times_num)

# 4-8 立方
num_first_cubes = []
for value in range(1,11):
    num_first_cubes.append(value ** 3)

for value in num_first_cubes:
    print(value)


# 4-9 立方解析
num_cubes = [value ** 3 for value in range(1,11)]
print('1-10 中数的立方：')
for num_cube in num_cubes:
    print(num_cube)

# 4-10 切片
planets = ['金星','木星','水星','火星','土星']
print('前三个元素是：' )
print(planets[:3])
print('中间的三个元素是：')
print(planets[1:4])
print('末尾的三个元素是：')
print(planets[-3:])

# 4-11 你的批萨和我的批萨
my_pizzas = ['p1','p2','p3','p4']
your_pizzas = my_pizzas[:]
my_pizzas.append('p5')
your_pizzas.append('p_five')
print(my_pizzas)
print(your_pizzas)

# 4-12 使用多个循环
for noodle in noodles:
    print(noodle)

for noodle in noodles[:]:
    print(noodle)

# 4-13 自助餐
buffets = ('土豆丝','泰山原浆','椒麻鸡','椰子汁')
for buffet in buffets:
    print(buffet)

buffets = ('土豆丝','泰山原浆','三杯鸡','烤鸭')
for buffet in  buffets:
    print(buffet)






