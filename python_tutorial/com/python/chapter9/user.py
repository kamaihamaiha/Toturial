class User():

    def __init__(self,first_name,last_name,age):
        self.first_name = first_name
        self.last_name = last_name
        self.age = age
        """登录次数属性"""
        self.login_attempts = 0

        """增加登录次数 1次"""
    def increment_login_attempts(self):
        self.login_attempts+=1

        """重置登录次数"""
    def reset_login_attempts(self):
        self.login_attempts = 0

    def describe(self):
        print(self.first_name + '.' + self.last_name + str(self.age) + '岁了！')

    def greet(self):
        print('Hello ' + self.first_name + '!')

user1 = User('Tomas','Cruize',33)
user2 = User('Porsche','Leslie',49)

user1.describe()
user2.describe()
user1.greet()
user2.greet()

# 9-5 尝试登录次数
user3 = User('小花','小草',13)
user3.increment_login_attempts()
user3.increment_login_attempts()
user3.increment_login_attempts()
print(user3.first_name + '登录了 ' + str(user3.login_attempts) + ' 次！')
user3.reset_login_attempts()
print('重置登录次数了！')
print(user3.first_name + '登录了 ' + str(user3.login_attempts) + ' 次！')

# 9-7 管理员
print('------------------------------管理员---------------------------------')
class Privileges():
    def __init__(self):
        self.privileges = ['can add post','can delete post','can ban user']
    def show_privileges(self):
        for value in self.privileges:
            print(value)

class Admin(User):
    def __init__(self,privileges):
        self.privileges = Privileges()

    def show_privileges(self):
        for value in self.privileges:
            print(value)

# admin = Admin(['can add post','can delete post','can ban user'])
# admin.show_privileges()

# 9-8 权限
print('------------------------------权限---------------------------------')
# 类的定义要在 Admin 前面

admin2 = Admin('')
admin2.privileges.show_privileges()