import sys

import pygame


def check_events(ship):
    """响应按键和鼠标事件"""
    for event in pygame.event.get():
        # pygame.QUIT 就是鼠标点击了窗口的关闭按钮
        if event.type == pygame.QUIT:
            sys.exit()
        elif event.type == pygame.KEYDOWN:
            if event.key == pygame.K_RIGHT:
                ship.img_rect.centerx += 15
            elif event.key == pygame.K_LEFT:
                ship.img_rect.centerx -= 15

def update_screen(screen,setting,ship):
    """更新屏幕操作"""

    # 每次循环时，重绘屏幕
    screen.fill(setting.bg_color)
    ship.place()

    # 让最近绘制的屏幕可见
    pygame.display.flip()