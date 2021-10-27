/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Point;
import javax.swing.*;
import java.util.Random;

/**
 *
 * @author Kpaco
 */
public class Level extends JPanel {
    int Screen_Width;
    int Screen_Height;
    int UNIT_SIZE=35;
    int GAME_UNITS;
    int X[];
    int Y[];
    int SnakeZize=3;
    int appleX;
    int appleY;
    char direction ='R';
    int obstacleX;
    int obstacleY;
    int xPos;
    int yPos;
    char dir='R';
    boolean changeDir=false;
    boolean gameOver=false;
    Point apple=new Point();
    Snake Player=new Snake(UNIT_SIZE);
    Walls Wall=new Walls();
    public Level(int x, int y)
    {
        Screen_Width=x;
        Screen_Height=y;
        xPos=Calc_QuarterScreen()+Player.snakeSize-1;
        Wall.createWall(UNIT_SIZE, Calc_QuarterScreen(), Calc_RightQuarter(), Screen_Height);
    }
    public Point GetWallPoint(int i)
    {
        return Wall.getArrayPoint(i);
    }
    public int getWallDistnaceY(int i)
    {
        return (int)Wall.getPointDistnaceY(i);
    }
    public int getWallDistnaceX(int i)
    {
        return (int)Wall.getPointDistnaceX(i);
    }
    public int Get_Gameunits()
    {
        return UNIT_SIZE;
    }
    public int[] Get_MapX()
    {
        return X;
    }
    public int[] Get_MapY()
    {
        return Y;
    }
    public int Get_ScreenHeight()
    {
        return  Screen_Height;
    }
    public int Get_ScreenWidth()
    {
        return  Screen_Width;
    }
    public int Get_MapSize()
    {
        return GAME_UNITS;
    }
    public void Generate_Map()
    {
        //put map from txt here if chosen.
    }
    public int Calc_QuarterScreen()
    {
        return (Screen_Width/4)/UNIT_SIZE;
    }
    public int Calc_RightQuarter()
    {
        return ((Screen_Width/4)*3)/UNIT_SIZE;
    }
    
    public void Move()
    {
        
        switch(GetSnakeDir())
        {
            case 'R':
                xPos++;
                if(!Player.checkSnakeGrow()) Player.advanceSnakeBody();
                else Player.addBody();
                Player.setHeadLocation(xPos*UNIT_SIZE,(int) Player.getSnakeHeadY());
                break;
            case 'D':
                yPos++;
                if(!Player.checkSnakeGrow()) Player.advanceSnakeBody();
                else Player.addBody();
                Player.setHeadLocation((int) Player.getSnakeHeadX(),yPos*UNIT_SIZE);
                break;
            case 'U':
                yPos--;
                if(!Player.checkSnakeGrow()) Player.advanceSnakeBody();
                else Player.addBody();
                Player.setHeadLocation((int) Player.getSnakeHeadX(),yPos*UNIT_SIZE);
                break;
            case 'L':
                xPos--;
                if(!Player.checkSnakeGrow())  Player.advanceSnakeBody();
                else Player.addBody();
                Player.setHeadLocation(xPos*UNIT_SIZE,(int) Player.getSnakeHeadY());
                break;
        }
    }
    public boolean checkCollision(int i)
    {
        if(Player.getHead().equals(Player.getArrayPoint(i)))
        {
            return true;
        }
        
        return false;
    }
    public boolean checkWallCollision()
    {
        int counter=0;
        for (int i = 0; i < 8; i=i+2) 
        {
            if(Player.getHead().getX()==Wall.getArrayPoint(i).getX() )
            {
                counter=(int)Wall.getArrayPoint(i).getY();
                for (int j = 0; j < Wall.getPointDistnaceY(i)/UNIT_SIZE; j++) 
                {
                    counter=counter+UNIT_SIZE;
                    if(Player.getHead().getY()==counter) return true;
                }
            }
            if(Player.getHead().getY()==Wall.getArrayPoint(i).getY())
            {
                counter=(int)Wall.getArrayPoint(i).getX();
                for (int j = 0; j < Wall.getPointDistnaceX(i)/UNIT_SIZE; j++) 
                {
                    counter=counter+UNIT_SIZE;
                    if(Player.getHead().getX()==counter) return true;
                }
            }
        }
        return false;
        
    }
    public boolean checkAppleGenCoords()
    {
        int counter;
        for (int i = 0; i < 8; i=i+2) 
        {
            if(apple.getX()==Wall.getArrayPoint(i).getX())
            {
                counter=(int)Wall.getArrayPoint(i).getY();
                for (int j = 0; j < Wall.getPointDistnaceY(i)/UNIT_SIZE; j++)
                {
                    counter=counter+UNIT_SIZE;
                    if (apple.getY()==counter) return true;
                }
            }
            else if(apple.getY()==Wall.getArrayPoint(i).getY())
            {
                counter=(int)Wall.getArrayPoint(i).getX();
                for (int j = 0; j < Wall.getPointDistnaceX(i)/UNIT_SIZE; j++)
                {
                    counter=counter+UNIT_SIZE;
                    if (apple.getX()==counter) return true;
                }
            }
        }
        for (int i = 0; i < Player.Snek.size()-1; i++) 
        {
            if(apple.equals(Player.Snek.get(i))) return true;
        }
        return false;
    }
    public double getSnakeHeadX()
    {
        Point help=new Point();
        help=Player.Snek.get(Player.Snek.size()-1);
        return help.getX();
    }
    public double getBodyX(int index)
    {
        return Player.getIBodyPartPointX(index);
    }
    public double getBodyY(int index)
    {
        return Player.getIBodyPartPointY(index);
    }
    public double getSnakeHeadY()
    {
        Point help=new Point();
        help=Player.Snek.get(Player.Snek.size()-1);
        return help.getY();
    }
    public int getSnakeSize()
    {
        return Player.getSnakeSize();
    }
    public void SetSnakeDir(char d)
    {
        dir=d;
    }
    public char GetSnakeDir()
    {
        return dir;
    }
  
    public void checkApple()
    {
        if(apple.equals(Player.getHead())) 
        {
            Player.growSnake();
            GenApple();
        }
    }
    public double Get_appleX()
    {
        return apple.getX();
    }
    public double Get_appleY()
    {
        return apple.getY();
    }
    public void GenApple()
    {
        Random ran=new Random();
        appleX=ran.nextInt((int)(Calc_RightQuarter())-Calc_QuarterScreen())+Calc_QuarterScreen();
        
        appleY=ran.nextInt((int)(Screen_Height/UNIT_SIZE))*UNIT_SIZE;
        apple.setLocation(appleX*UNIT_SIZE,appleY);
    }
}
