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