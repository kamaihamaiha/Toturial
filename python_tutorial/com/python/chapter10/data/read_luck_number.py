import json
# 10-11 读取用户喜欢的数字

filename = 'luck_number.json'
try:
    with open(filename) as file_obj:
        luck_number = json.load(file_obj)
except FileNotFoundError:
    print('The file does not exits!')
else:
    print("User's favourite number is: " + str(luck_number))
