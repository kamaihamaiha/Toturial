from com.python.chapter10.except_.word_count import WordCount
# 10.3.5 处理 FileNotFoundError 异常
file_name = 'alic.txt'
try:
    with open(file_name) as file_obj:
        value = file_obj.read()
except FileNotFoundError:
    print('The file: ' + file_name + ' does not exist!')

# 10.3.6 分析文本
# 计算文本中有多少单词，读取文件到字符串变量中，然后用 split() 分隔
print('+++++++++++++ 计算文本中有多少单词，读取文件到字符串变量中，然后用 split() 分隔')
file_name2 = 'alice.txt'
try:
    with open(file_name2) as file_obj:
        contents = file_obj.read()
except FileNotFoundError:
    print('The file: ' + file_name + ' does not exist!')
else:
    print('The file: ' + file_name + ' has about ' + str(len(contents.split())) + ' words.')

# 10.3.7 使用多个文件
print('++++++++++++++++++++++++++++++++++ 使用多个文件')

book_file_1 = 'alice.txt'
book_file_2 = 'siddhartha.txt'
book_file_3 = 'little_women2.txt'
word_counter = WordCount(book_file_1,book_file_2,book_file_3)
word_counter.count_words()