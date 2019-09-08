class AnonymousSurvey():
    """收集匿名调查文件的答案"""

    def __init__(self,question):
        """存储问题，并且准备存储答案"""
        self.question = question
        self.responses = []

    def show_question(self):
        print(self.question)

    def store_response(self,response):
        """存储答案"""
        self.responses.append(response)

    def show_results(self):
        """显示收集到的所有答案"""
        print('调查结果：')
        for value in self.responses:
            print('- ' + value)