import json
file_name = 'luck_number.json'
luck_num = input('Please input your favorite number:')
with open(file_name,'w') as file_obj:
    luck_num = int(luck_num)
    json.dump(luck_num,file_obj)