import unittest
from com.python.chapter11.city_functions import get_city_info

class TestCityInfoCase(unittest.TestCase):

    def test_city_country(self):
        city_info = get_city_info('santiago','chile')
        self.assertEqual(city_info,'Santiago, Chile')


    def test_city_country_population(self):
        city_info = get_city_info('santiago','chile',1000000)
        self.assertEqual(city_info,'Santiago, Chile - ' + str(1000000))

unittest.main