/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Point;
import java.awt.geom.Point2D;
import javax.swing.*;
import java.util.Random;

/**
 *
 * @author Kpaco
 */
public class Level extends JPanel {
    double Screen_Width;
    double Screen_Height;
    double MAP_UNITS=40;
    double UNIT_SIZE;
    double appleX;
    double appleY;
    char direction ='R';
    double xPos;
    double yPos;
    char dir='R';
    Random ran=new Random();
    Point apple=new Point();
    Snake Player=new Snake();
    Walls Wall=new Walls();
    
    public void ConstructLvL(int x,int y)
    {
        Screen_Width=x;
        Screen_Height=y;
        UNIT_SIZE=Math.round(Screen_Width/MAP_UNITS);
        Player.CreateSnake(UNIT_SIZE);
        xPos=Calc_QuarterScreen()+Player.snakeSize-1;
        Wall.createWall(UNIT_SIZE, Calc_QuarterScreen(), Calc_RightQuarter(), Screen_Height);
    }
    public Point2D.Double GetWallPoint(int i)
    {
        return Wall.getArrayPoint(i);
    }
    public void Set_Gameunits(int x)
    {
        MAP_UNITS=x;
    }
    public double Get_Gameunits()
    {
        return UNIT_SIZE;
    }
    public double Get_ScreenHeight()
    {
        return  Screen_Height;
    }
    public double Get_ScreenWidth()
    {
        return  Screen_Width;
    }
    public double Calc_QuarterScreen()
    {
        return Math.round((Screen_Width/4)/UNIT_SIZE);
    }
    public double Calc_RightQuarter()
    {
        return Math.round(((Screen_Width/4)*3)/UNIT_SIZE);
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
        return Player.getHead().equals(Player.getArrayPoint(i));
    }
    public boolean checkWallCollision()
    {
        int start=0;
        int end=0;
        for (int i = 0; i < 8; i=i+2) 
        {
            if(Player.getHead().getX()==Wall.getArrayPoint(i).getX() )
            {
                start=(int)Wall.getArrayPoint(i).getY();
                end=(int)Wall.getArrayPoint(i+1).getY();   
                if(start<=Player.getHead().getY()&&Player.getHead().getY()<=end) return true;
            }
            else if(Player.getHead().getY()==Wall.getArrayPoint(i).getY())
            {
                start=(int)Wall.getArrayPoint(i).getX();
                end=(int)Wall.getArrayPoint(i+1).getX();
                if(start<=Player.getHead().getX()&&Player.getHead().getX()<=end) return true;
            }
        }
        return false;
        
    }
    public boolean checkAppleGenCoords()
    {
        int start=0;
        int end=0;
        for (int i = 0; i < 8; i=i+2) 
        {
            if(apple.getX()==Wall.getArrayPoint(i).getX())
            {
                start=(int)Wall.getArrayPoint(i).getY();
                end=(int)Wall.getArrayPoint(i+1).getY();   
                if(start<=apple.getY()&&apple.getY()<=end) return true;
            }
            else if(apple.getY()==Wall.getArrayPoint(i).getY())
            {
                start=(int)Wall.getArrayPoint(i).getX();
                end=(int)Wall.getArrayPoint(i+1).getX();
                if(start<=apple.getX()&&apple.getX()<=end) return true;
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
        return Player.Snek.get(Player.Snek.size()-1).getX();
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
      
        return Player.Snek.get(Player.Snek.size()-1).getY();
        
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
            do
            {
                GenApple();
            }
            while(checkAppleGenCoords());
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
        appleX=Math.round(Calc_QuarterScreen()+(Calc_RightQuarter()-Calc_QuarterScreen())*ran.nextInt());
        appleY=Math.round((Screen_Height/UNIT_SIZE)*ran.nextInt()*UNIT_SIZE);
        apple.setLocation(appleX*UNIT_SIZE,appleY);
    }
}
