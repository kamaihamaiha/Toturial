from collections import OrderedDict

languages = OrderedDict()

languages['first'] = 'Python'
languages['second'] = 'Java'
languages['third'] = 'Go'
languages['forth'] = 'Shell'


for order,language in languages.items():
    print('The ' + order + ' language is ' + language)