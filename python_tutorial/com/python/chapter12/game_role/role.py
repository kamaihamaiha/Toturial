import sys

import pygame

def show():
    pygame.init()

    screen = pygame.display.set_mode((500,400))
    bg_color = (200,210,220)
    pygame.display.set_caption('卡卡洛特')
    img = pygame.image.load('/home/kk/PycharmProjects/python_tutorial/com/python/chapter12/game_role/goku_boy.png')
    img_rect = img.get_rect()
    screen_rect = screen.get_rect()
    img_rect.centerx = screen_rect.centerx
    img_rect.centery = screen_rect.centery

    while True:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                sys.exit()

            # 放置图片
            screen.fill(bg_color)
            screen.blit(img,img_rect)
            pygame.display.flip()


show()