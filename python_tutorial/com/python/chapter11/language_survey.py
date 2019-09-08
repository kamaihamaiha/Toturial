from com.python.chapter11.survey import AnonymousSurvey

question = 'What language did you first learn to speak?'
survey = AnonymousSurvey(question)
# 显示问题
survey.show_question()

# 存储答案
print('Enter "q" to exit at any time.')
while True:
    response = input('Language:')
    if response == 'q':
        break
    survey.store_response(response)

# 显示调查结果
print('\n谢谢配合！')
survey.show_results()