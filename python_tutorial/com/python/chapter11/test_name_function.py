import unittest
from com.python.chapter11.name_function import get_formatted_name

class NamesTestCase(unittest.TestCase):
    """测试 name_function.py """

    def test_first_last_name(self):
        """能够正确处理像 Lionel Messi 这样的姓名吗？ """
        full_name = get_formatted_name('lionel', 'Messi')
        # 断言方法
        self.assertEqual(full_name, 'Lionel Messi')

    def test_first_last_middle_name(self):
        """能够正确处理像 One Two Three 这样的姓名吗？ """
        full_name = get_formatted_name('one', 'two','middle')
        # 断言方法
        self.assertEqual(full_name, 'One Middle Two')


# 让 Python 运行这个文件中的测试。注意是 main, 而不是 main()。具体原因目前不清楚
unittest.main
