# 定义一个字符串变量
message = "Good Morning!";
print(message)

# 2.3.1 使用方法修改字符串的大小写
"""
title() 方法，以首字母大写的方式显示每个单词
"""
language = "java"
print(language.title())
print(language.title().lower())
print(language.title().upper())

language_python = "python"

print(language + " and " + language_python)
print("languages:\n\tPython\n\tJava\n\tC++")

language_input = " Python  "
# rstrip() 删除[右边的]空格是暂时的
print(language_input.rstrip()+"!")
# rstrip() 删除[左边的]空格是暂时的
print(language_input.lstrip())
# rstrip() 删除[两边的]空格是暂时的
print(language_input.strip())