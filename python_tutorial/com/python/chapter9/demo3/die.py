from random import randint
class Die():
    """骰子"""
    def __init__(self,sides=6):
        """属性 sides 是骰子的面的个数"""
        self.sides = sides

    def roll_sides(self):
        return randint(1,self.sides)
