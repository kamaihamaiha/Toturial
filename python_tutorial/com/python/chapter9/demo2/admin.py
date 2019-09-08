from com.python.chapter9.demo2.user import User
from com.python.chapter9.demo2.privileges import Privileges
class Admin(User):
    def __init__(self,privileges):
        self.privileges = Privileges().privileges

    def show_privileges(self):
        for value in self.privileges:
            print(value)