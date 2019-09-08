from collections import OrderedDict

importants = OrderedDict()

importants['Pthon'] = '蟒蛇'
importants['pop'] = '删除并返回'
importants['insert'] = '插入元素'
importants['sort'] = '排序'
importants['range'] = '按范围取值'
importants['if'] = '如果'
importants['else'] = '否则'
importants['key'] = '键'
importants['value'] = '值'
importants['del'] = '删除'

for key,value in importants.items():
    print('The ' + key + ' is ' + value)