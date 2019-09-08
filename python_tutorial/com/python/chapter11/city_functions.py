
def get_city_info(city_name,country_name,population=''):
    if population:
        return city_name.title() + ', ' + country_name.title() + ' - ' + str(population)
    else:
        return city_name.title() + ', ' + country_name.title()

