class WordCount():
    """单词操作类"""
    def __init__(self,*books):
        self.books = books

    """计算一个文件或这多个文件各自大致包含多少个单词"""
    def count_words(self):
        for book in self.books:
            book_name = book

            try:
                with open(book_name) as file_obj:
                    contents = file_obj.read()
            except FileNotFoundError:
                # 如果错误发生了，不想提示出来，也不想做其他的操作，那么可以执行： pass.放开注释即可
                # pass
                print('The file: ' + book_name + ' does not exits!')
            else:
                print('The file: ' + book_name + ' has ' + str(len(contents.split())) + ' words.')


