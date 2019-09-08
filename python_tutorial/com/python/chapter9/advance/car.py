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

    def increment_odometer(self, miles):
        if miles > 0:
            self.odometer += miles
        else:
            print('递增不能传递小于 0 的里程！')

    def fill_gas_tank(self):
        print('加满邮箱！')


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