import unittest
from com.python.chapter11.employee import Employee

class TestEmployeeCase(unittest.TestCase):

    def setUp(self):
        self.default_salary = 60000000
        self.my_employee = Employee('Lionel','Messi',self.default_salary)

    def test_give_default_raise(self):
        self.my_employee.give_raise()
        self.assertEqual(self.default_salary + 5000,self.my_employee.salary)

    def test_give_custom_raise(self):
        self.my_employee.give_raise(99999)
        self.assertEqual(self.default_salary + 99999,self.my_employee.salary)

unittest.main