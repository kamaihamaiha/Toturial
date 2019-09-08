import unittest
from com.python.chapter11.survey import AnonymousSurvey

class TestAnonymousSurveyCast(unittest.TestCase):
    """对 AnonymousSurvey 类的测试"""

    def test_store_single_response(self):
        """测试单个答案是否能妥善的保存"""
        question = 'What language did you first learn to speak?'
        my_survey = AnonymousSurvey(question)
        my_survey.store_response('Chinese')

        self.assertIn('Chinese',my_survey.responses)

    def test_store_three_responses(self):
        """测试单个答案是否能妥善的保存"""
        question = 'What language did you first learn to speak?'
        my_survey = AnonymousSurvey(question)
        responses = ['Chinese','Japanese','English']
        for response in responses:
            my_survey.store_response(response)

        for response in responses:
            self.assertIn(response,my_survey.responses)


unittest.main