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