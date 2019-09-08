from com.python.chapter9.advance.car import Car
# 导入方式，用的是全路径方式。并不是 from car inport Car。因为 com.pathon 并不是一个严格意义的包，其中没有 __init__.py 文件
my_new_car = Car('Honda','Type-R',2018,480)
my_new_car.update_odometer(80)
my_odometer = my_new_car.read_odometer()
print(my_odometer)