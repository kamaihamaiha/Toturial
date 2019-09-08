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




