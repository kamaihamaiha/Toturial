class Car():
    def __init__(self, make, model, year, power):
        self.make = make
        self.model = model
        self.year = year
        self.power = power
        """给汽车初始化里程值"""
        self.odometer = 0

    def describe(self):
        """返回描述汽车的一条信息"""
        des_info = '一辆 ' + str(self.year) + ' 的 ' + self.make + ' ' + self.model + ', 有 ' + str(self.power) + ' 匹马力！'
        return des_info

    def read_odometer(self):
        return '这辆车跑了 ' + str(self.odometer) + ' Km'

    def update_odometer(self, mileage):
        """里程数只能变大不能减小"""
        if mileage >= self.odometer:
            self.odometer = mileage
        else:
            print('时光不能倒流，里程不能减小！')

    def increment_odometer(self,miles):
        if miles > 0:
            self.odometer += miles
        else:
            print('递增不能传递小于 0 的里程！')

    def fill_gas_tank(self):
        print('加满邮箱！')


car0 = Car('Toyota', '86', 2009, 230)
print(car0.describe())
print(car0.read_odometer())

# 9.2.3 修改属性的值
# 1. 直接修改属性的值
car0.odometer = 20
print(car0.read_odometer())

# 2. 通过方法修改属性的值
car0.update_odometer(55)
print(car0.read_odometer())

car0.update_odometer(50)
print(car0.read_odometer())
car0.update_odometer(60)
print(car0.read_odometer())

# 3. 通过方法修改属性的值-让其递增
car0.increment_odometer(3)
print(car0.read_odometer())

# +++++++++++++++++++++++++++++++++++++++++++++++++++++++
# 9.3 继承

class Battery():
    def __init__(self,battery_size=70):
        """初始化电瓶的容量"""
        self.battery_size = battery_size

    def describe_battery(self):
        print('这个电动汽车电池容量是： ' + str(self.battery_size) + 'Kwh')

    """获取剩余续航里程"""
    def get_range(self):
        range = self.battery_size * 5
        print('还能跑 ' + str(range) + ' Km')

        """升级电瓶"""
    def upgrade_battery(self):
        if self.battery_size != 85:
            self.battery_size = 85

class ElectricCar(Car):
    def __init__(self,make,model,year,power):
        """初始化父控件的属性"""
        super().__init__(make,model,year,power)
        """电动车有电瓶，初始化电瓶"""
        self.battery = Battery()

    def describe_battery(self):
        """打印电瓶信息"""
        print('这个电动汽车电池容量是： ' + str(self.battery.battery_size) + 'Kwh')

    def fill_gas_tank(self):
        print('电动汽车不需要加燃油！')

    def drive(self):
        self.battery.battery_size -= 5

tesla = ElectricCar('Tesla','model 3',2018,400)
print(tesla.describe())
tesla.describe_battery()

# 重写父类方法
tesla.fill_gas_tank()

# 9.3.5 用自定义类的实例作为属性
print('--------------------用自定义类的实例作为属性----------------------')
# Battery 的定义，见上面 9.3

my_tesla_1 = ElectricCar('Tesla','Model 3',2019,450)
my_tesla_1.battery.describe_battery()
my_tesla_1.battery.get_range()
my_tesla_1.drive()
my_tesla_1.battery.get_range()

# 9-9 电瓶升级
print('--------------------电瓶升级-----------------------------------')
# 见上面的 Battery
my_tesla_2 = ElectricCar('Tesla','Model 3',2020,770)
my_tesla_2.describe_battery()
my_tesla_2.battery.upgrade_battery()
my_tesla_2.describe_battery()