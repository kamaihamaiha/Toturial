from com.python.chapter9.advance.car import ElectricCar

my_electric_car = ElectricCar('BYD','秦',2017,380)
my_electric_car.update_odometer(200)
print(my_electric_car.read_odometer())
print(my_electric_car.describe())
