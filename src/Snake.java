/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Point;
import java.util.*;
import java.lang.Math;
/**
 *
 * @author Kpaco
 */
public class Snake {
    int snakeSize=3;
    Point head=new Point();
    Point bodyPart=new Point();
    Point Help=new Point();
    boolean growsnake=false;
    ArrayList<Point>Snek=new ArrayList<Point>();
    public Snake(int UNIT_SIZE)
    {
        head.setLocation(3*UNIT_SIZE,1*UNIT_SIZE);
        
        for (int i = 0; i < snakeSize-1; i++) {
            bodyPart=new Point(i*UNIT_SIZE,0);
            Snek.add(bodyPart);
        }
        Snek.add(head);
    }
    public Point getArrayPoint(int index)
    {
        return Snek.get(index);
    }
    public void setHeadLocation(int a, int b)
    {
        head.setLocation(a,b);
        Snek.set(Snek.size()-1, head);
    }
    public void setBodyLocation(int a,int b,int index)
    {
        bodyPart=new Point(a,b);
        Snek.set(index, bodyPart);
    }
    public void advanceSnakeBody()
    {
        Snek.remove(0);
        Snek.add(Snek.indexOf(head),bodyPart=new Point(head));
    }
    public void growSnake()
    {
        growsnake=true;
    }
    public void addBody()
    {
        Snek.add(Snek.indexOf(head),bodyPart=new Point(head));
    }
    public Point getHead()
    {
        return head;
    }
    public int getIBodyPartPointX(int index)
    {
        Help=Snek.get(index);
        int a=(int)Help.getX();
        return a;
    }
    public int getIBodyPartPointY(int index)
    {
        Help=Snek.get(index);
        int a=(int)Help.getY();
        return a;
    }
    public double getSnakeHeadX()
    {
        return head.getX();
    }
    public double getSnakeHeadY()
    {
        return head.getY();
    }
    
    public boolean checkSnakeGrow()
    {
        if(growsnake)
        {
            growsnake=false;
            return true;
        }
        return false;
    }
    
    public void setSnakeSize(int a)
    {
        snakeSize=a;
    }
    public int getSnakeSize()
    {
        return Snek.size();
    }
   
}
