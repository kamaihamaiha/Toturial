from com.python.chapter9.advance2.car import Car
from com.python.chapter9.advance2.battery import Battery
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