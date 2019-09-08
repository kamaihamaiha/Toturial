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
