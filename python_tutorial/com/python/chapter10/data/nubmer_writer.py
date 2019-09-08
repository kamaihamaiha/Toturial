import json

# 用 json.dump() 存储数字列表
numbers = [3,1,4,1,5,9,2,6]
file_name = 'numbers.json'
with open(file_name,'w') as f_obj:
    # 存储数字列表
    json.dump(numbers,f_obj)

# 上面已经把数字列表写入到了文件 numbers.json 中，然后在读取出来看看
with open(file_name) as file_obj:
    numbers_value = json.load(file_obj)

print(numbers_value)