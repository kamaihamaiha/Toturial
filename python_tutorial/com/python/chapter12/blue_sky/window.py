import sys

import pygame


def create_pop():
    pygame.init()
    screen = pygame.display.set_mode((400, 300))
    bg_color = (0,0,200)
    pygame.display.set_caption('蓝色屏幕')

    while True:

        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                sys.exit()

        screen.fill(bg_color)
        pygame.display.flip()


create_pop()
