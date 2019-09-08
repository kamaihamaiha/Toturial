# 10.3.2 使用 try-except 代码块
try:
    print(5 / 0)
except ZeroDivisionError:
    print('0 不能当作除数！')

# 10.3.3 使用异常避免崩溃 + 10.3.4 else 代码块
# 只执行除法的计算器：
print('++++++++++++++++++ 只执行除法的计算器：')

print("Give me two numbers, and I'll divide them.")
print("Enter 'q' to quit.")

while True:
    first_number = input('\nFirst Number: ')
    if first_number == 'q':
        break
    second_number = input('\nSecond Number: ')
    if second_number == 'q':
        break
    try:
        answer = int(first_number) / int(second_number)
    except ZeroDivisionError:
        print('0 不能当作除数,请重新输入！')
    # 依赖于上面的 try 代码块中成功执行的代码，要放在下面的 else 代码块中
    else:
        print(answer)