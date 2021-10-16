/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Point;
import java.util.*;
/**
 *
 * @author Kpaco
 */
public class Snake {
    int snakeSize=3;
    char dir='R';
    Point head=new Point();
    Point lastbody=new Point();
    Point nullPoint=new Point();
    
    ArrayList<Point>Snek=new ArrayList<Point>();
    public Snake(int UNIT_SIZE, int QuarterWindow)
    {
        nullPoint.setLocation(0,0);
        head.setLocation(0*UNIT_SIZE,0*UNIT_SIZE);
        lastbody.setLocation(1*UNIT_SIZE,1*UNIT_SIZE);
        
        Snek.add(0,lastbody);
        for (int i = 0; i <= snakeSize-2; i++) {
        Snek.add(nullPoint);
        }
        Snek.add(head);
        
    }
    public int getBodyHeadDistance()
    {
        return Snek.size()-1;
    }
    public void setHeadLocation(int a, int b)
    {
        head.setLocation(a,b);
        Snek.set(Snek.size()-1, head);
    }
    public void setTailLocation(int a, int b)
    {
        lastbody.setLocation(a,b);
        Snek.set(0, lastbody);
    }
    public double getSnakeHeadX()
    {
        return head.getX();
    }
    public double getSnakeTailX()
    {
        return lastbody.getX();
    }
    public void growSnake()
    {
        Snek.set(Snek.lastIndexOf(head),nullPoint);
        Snek.add(head);
    }
    
    public void setSnakeSize(int a)
    {
        snakeSize=a;
    }
    public void SetSnakeDir(char d)
    {
        dir=d;
    }
    public char GetSnakeDir()
    {
        return dir;
    }
    public int getSnakeSize()
    {
        return Snek.size();
    }
   
}
