def create_car(brand, country, **car_info):
    car = {}
    car['brand'] = brand
    car['country'] = country
    for key, value in car_info.items():
        car[key] = value
    return car

def hello():
    print('hello, I can create car!')