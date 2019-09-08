class Restaurant():
    def __init__(self,name,type):
        self.name = name
        self.type = type
        self.number_served = 0

    def describe_restaurant(self):
        print('有一个叫 ' + self.name + ' 的宾馆，是 ' + self.type)

    def open_restaurant(self):
        print(self.name + '开业了！')

    def set_number_served(self,num):
        self.number_served = num

    def increment_number_served(self,num):
        if num >= 0:
            self.number_served += num
        else:
            print('就餐人数不能递减！')


# 调用定义的类及其属性和方法
restaurant = Restaurant('喜来登酒店','五星级')
print(restaurant.name)
print(restaurant.type)
restaurant.describe_restaurant()
restaurant.open_restaurant()

# 9-2 三家餐馆
print('--------------------------三家餐馆--------------------')
restaurant1 = Restaurant('和平饭店','五星级')
restaurant2 = Restaurant('七天连锁酒店','一星级')
restaurant3 = Restaurant('格林豪泰','一星级')

restaurant1.describe_restaurant()
restaurant2.describe_restaurant()
restaurant3.describe_restaurant()

# 9-4 就餐人数
restaurant4 = Restaurant('胖子烧烤','大排档')
print('有 ' + str(restaurant4.number_served) + ' 人来' + restaurant4.name + restaurant4.type + ' 吃饭！')

restaurant4.set_number_served(4)
print('有 ' + str(restaurant4.number_served) + ' 人来' + restaurant4.name + restaurant4.type + ' 吃饭！')

restaurant4.increment_number_served(200)
print('有 ' + str(restaurant4.number_served) + ' 人来' + restaurant4.name + restaurant4.type + ' 吃饭！')

# 9-6 冰淇淋小店
class IceCreamStand(Restaurant):
    def __init__(self,flavors):
        self.flavours = flavors

    def list_flavours(self):
        for value in self.flavours:
            print(value)

my_ice = IceCreamStand(['小布丁','哈根达斯','兵工厂'])
my_ice.list_flavours()