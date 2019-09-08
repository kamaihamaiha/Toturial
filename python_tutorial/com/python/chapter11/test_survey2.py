import unittest
from com.python.chapter11.survey import AnonymousSurvey

class TestAnonymousSurveyCast(unittest.TestCase):
    """对 AnonymousSurvey 类的测试"""

    def setUp(self):
        """这个方法可以只实例化对象一次，每个测试方法都会使用"""
        question = 'What language did you first learn to speak?'
        self.my_survey = AnonymousSurvey(question)
        self.responses = ['Chinese', 'Japanese', 'English']

    def test_store_single_response(self):
        """测试单个答案是否能妥善的保存"""
        self.my_survey.store_response(self.responses[0])

        self.assertIn(self.responses[0],self.responses)

    def test_store_three_responses(self):
        """测试单个答案是否能妥善的保存"""
        for response in self.responses:
            self.my_survey.store_response(response)

        for response in self.responses:
            self.assertIn(response,self.my_survey.responses)


unittest.main