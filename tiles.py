#IMPORTS---------------------------------------------------------------------------------

import pygame
from time import sleep
import random

#INITIALISATION--------------------------------------------------------------------------

pygame.init()

gameDisplay = pygame.display.set_mode((800,600))
pygame.display.set_caption("MEMORY TILES")

clock = pygame.time.Clock()

txt_font = pygame.font.Font("freesansbold.ttf",45)
    
#COLOR CODE------------------------------------------------------------------------------

black = (0,0,0)
white = (225,225,225)
gray = (110,110,110)
orange = (255,140,0)
dark_orange = (205,102,0)
brown = (138,54,15)

#GAME CODE---------------------------------------------------------------------------------

score = 0

base={}
for i in range(1,37):
        base[i]=gray
gbase={}

def default():
    for i in range(1,37):
        gbase[i]=gray

def game_grid():
    global gbase
    for i in range(9):
        i = random.randint(1,36)
        gbase[i] = orange

def clear_base():
    for i in range(1,37):
        base[i] = gray
    display(base)

def button():
    x,y,w,h=50,35,60,60
    for i in range(1,37):
        if i%6 == 1:
            y += 80
            x = 50
        else:
            x += 80
        if x+w > mouse[0] > x and y+h > mouse[1] > y:
            if click == True:
                base[i] = orange

def result(res,colour):
    pygame.draw.rect(gameDisplay,dark_orange,(550,350,200,100))
    txt = txt_font.render(res,True,colour)
    TextRect = txt.get_rect() 
    TextRect.center = (650,400)
    gameDisplay.blit(txt, TextRect)
    pygame.display.update()
    sleep(1)
            
def check(score):
    if gbase == base:
        result("CORRECT",white)
        clear_base()
        game_grid()#change this step plx
        score += 1
    else:
        result("WRONG",black)
        clear_base()
        score = 0
    
    return score

def display(dict):
    x,y=50,35
    for i in range(1,37):
        if i%6 == 1:
            y += 80
            x = 50
        else:
            x += 80
        pygame.draw.rect(gameDisplay,dict[i],(x,y,60,60))
    pygame.display.update()

def start_page(score):
    gameDisplay.fill(black)
    txt = txt_font.render("WELCOME TO MEMORY TILES",True,dark_orange)
    TextRect = txt.get_rect() 
    TextRect.center = (400, 50)
    gameDisplay.blit(txt, TextRect)

    pygame.draw.rect(gameDisplay,dark_orange,(550,110,200,100))
    pygame.draw.rect(gameDisplay,dark_orange,(550,230,200,100))
    pygame.draw.rect(gameDisplay,dark_orange,(530,350,240,100))

    
    txt = txt_font.render("CLEAR",True,white)
    TextRect = txt.get_rect() 
    TextRect.center = (650,280)
    gameDisplay.blit(txt, TextRect)

    txt = txt_font.render("START!",True,white)
    TextRect = txt.get_rect() 
    TextRect.center = (650,160)
    gameDisplay.blit(txt, TextRect)

    txt = txt_font.render("CHECK",True,white)
    TextRect = txt.get_rect() 
    TextRect.center = (650,400)
    gameDisplay.blit(txt, TextRect)
    
    txt = txt_font.render("SCORE : " + str(score),True,white)
    TextRect = txt.get_rect() 
    TextRect.center = (650,520)
    gameDisplay.blit(txt, TextRect)

while True:
    
    mouse = pygame.mouse.get_pos() 
    click = pygame.mouse.get_pressed()

    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            quit()

        if event.type == pygame.MOUSEBUTTONUP:
            click = True
        
        if 750 > mouse[0] > 550 and 210 > mouse[1] > 110:
            pygame.draw.rect(gameDisplay,orange,(550,110,200,100))
            txt_font2 = pygame.font.Font("freesansbold.ttf",25)
            txt = txt_font.render("START!",True,brown)
            TextRect = txt.get_rect() 
            TextRect.center = (650,160)
            gameDisplay.blit(txt, TextRect)
            pygame.display.update()

            if click == True:
                default()
                game_grid()
                display(gbase)
                sleep(2)

        if 750 > mouse[0] > 550 and 320 > mouse[1] > 230:
            pygame.draw.rect(gameDisplay,orange,(550,230,200,100))
            txt = txt_font.render("CLEAR",True,white) #not working
            TextRect = txt.get_rect() 
            TextRect.center = (650,280)
            gameDisplay.blit(txt, TextRect)
            pygame.display.update()

            if click== True:
                clear_base()
        
        if 750 > mouse[0] > 550 and 450 > mouse[1] > 350:
            if click == True:
                score = check(score)
                
    start_page(score)
    display(base)
    button()
    pygame.display.update()
    
    clock.tick(60)