class Dog():
    def __init__(self,name,age):
        """初始化属性 name 和 age"""
        self.name = name
        self.age = age

    def sit(self):
        """模拟命令小狗坐下"""
        print(self.name + '现在就坐下吧！')

    def bark(self):
        """模拟小狗叫"""
        print(self.name + '汪汪汪！')

my_dog = Dog('Leo',1)
my_dog.sit()
my_dog.bark()

my_dog1 = Dog('Kitty',3)
my_dog1.sit()
my_dog1.bark()