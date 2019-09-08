import json

"""保存用户输入的数字"""


def save_number():
    file_name = 'luck_number.json'
    luck_num = input('Please input your favorite number:')
    with open(file_name, 'w') as file_obj:
        luck_num = int(luck_num)
        json.dump(luck_num, file_obj)


"""获取用户输入的数字"""


def get_number():
    filename = 'luck_number.json'
    try:
        with open(filename) as file_obj:
            luck_number = json.load(file_obj)
    except FileNotFoundError:
        print('The file does not exits!')
        return None
    else:
        return luck_number


number = get_number()
if number:
    print("User's favourite number is: " + str(number))
else:
    save_number()
