# def get_formatted_name(first_name,last_name):
#     """生成全名"""
#     full_name = first_name + " " + last_name
#     return full_name.title()

def get_formatted_name(first_name, last_name, middle_name=''):
    """生成全名"""
    if middle_name:
        full_name = first_name + ' ' + middle_name + ' ' + last_name
    else:
        full_name = first_name + ' ' + last_name
    return full_name.title()
