from com.python.chapter9.demo.restaurant import Restaurant
from com.python.chapter9.demo.user import Admin

print('----------------- 9-10 导入 Restaurant 类 -----------------------')
my_restaurant = Restaurant('罗马假日酒店','五星级')
my_restaurant.describe_restaurant()

print('----------------- 9-11 导入 Admin 类 -----------------------')

my_admin = Admin(['抽烟','喝酒','烫头'])
my_admin.show_privileges()