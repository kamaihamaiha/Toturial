import json

# 10.4.2 保存和读取用户生成的数据
# file_name = 'username.json'
# try:
#     with open(file_name) as file_obj:
#         user_name = json.load(file_obj)
# except FileNotFoundError:
#     # 没有保存过，那就提示用户输入名字。
#     user_name = input('What is your name?')
#     with open(file_name, 'w') as file_obj:
#         json.dump(user_name, file_obj)
#         print("We'll remember you when you come back, " + user_name + '!')
# else:
#     print("Welcome back, " + user_name + '!')


# 10.4.3 重构
# 重构上面的操作，划分成多个人物清晰的方法
print('++++++++++++++++++++++++++++++ 10.4.3 重构')
def get_stored_username():
    """如果已经存储了该用户，那么就获取用户信息"""
    file_name = 'username.json'
    try:
        with open(file_name) as file_obj:
            user_name = json.load(file_obj)
    except FileNotFoundError:
        return None
    else:
        return user_name


def save_new_username():
    """如果没有该用户，就保存下来"""
    file_name = 'username.json'
    user_name = input('What is your name?')
    with open(file_name,'w') as file_obj:
        json.dump(user_name,file_obj)
    return user_name

def greet_user():
    """和用户打招呼"""
    user_name = get_stored_username()
    if user_name:
        print("Welcome back, " + user_name + '!')
    else:
        user_name = save_new_username()
        print("We'll remember you when you come back, " + user_name + '!')


# 调用函数
# greet_user()

# 10-13 验证用户

def check_user():
    user_name = get_stored_username()
    print('用户名为： ' + user_name)
    check = input('请确认， y/n?')
    if check == 'y':
        return True
    if check == 'n':
        return False
    else:
        print('输入错误！')
        return False

result = check_user()
if result:
    greet_user()
else:
    save_new_username()