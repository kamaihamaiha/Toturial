import pygame

class Ship():

    def __init__(self,screen):
        """初始化飞船，并设置其初始位置"""
        self.screen = screen

        # 加载飞船图形
        self.img = pygame.image.load('/home/kk/PycharmProjects/python_tutorial/com/python/chapter12/alien_invasion/images/ship.png')
        # 获取外接矩形
        self.img_rect = self.img.get_rect()
        self.screen_rect = self.screen.get_rect()

        # 把每艘飞船放到屏幕底部中央
        self.img_rect.centerx = self.screen_rect.centerx
        self.img_rect.bottom = self.screen_rect.bottom


    def place(self):
        """在指定位置绘制飞船"""
        self.screen.blit(self.img,self.img_rect)

