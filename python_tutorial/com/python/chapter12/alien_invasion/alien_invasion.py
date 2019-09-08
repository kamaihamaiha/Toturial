import pygame

from com.python.chapter12.alien_invasion.settings import Settings
from com.python.chapter12.alien_invasion.ship import Ship
from com.python.chapter12.alien_invasion import game_functions as gf

def run_game():
    # 初始化游戏并创建一个屏幕对象
    pygame.init()
    my_setting = Settings()
    screen = pygame.display.set_mode((my_setting.screen_width,my_setting.screen_height))
    pygame.display.set_caption(my_setting.title)

    # 创建一艘飞船
    ship = Ship(screen)

    # 开始游戏的主循环
    while True:

        # 监听键盘和鼠标事件
        gf.check_events(ship)

        # 重新绘制屏幕
        gf.update_screen(screen,my_setting,ship)

run_game()