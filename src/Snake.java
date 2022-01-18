/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.*;
import java.lang.Math;

import java.awt.geom.Point2D;

/**
 *
 * @author Kpaco
 */
public class Snake {
    int snakeSize=3;
    Point2D.Double head=new Point2D.Double();
    Point2D.Double bodyPart=new Point2D.Double();
    boolean growsnake=false;
    ArrayList<Point2D.Double>Snek=new ArrayList<Point2D.Double>();
    public Snake()
    {
    }
    public void CreateSnake(double UNIT_SIZE)
    {
         head.setLocation(3*UNIT_SIZE,1*UNIT_SIZE);
        
        for (int i = 0; i < snakeSize-1; i++) {
            bodyPart=new Point2D.Double(i*UNIT_SIZE,0);
            
            Snek.add(bodyPart);
        }
        Snek.add(head);
    }
    public Point2D.Double getArrayPoint(int index)
    {
        return Snek.get(index);
    }
    public void setHeadLocation(double a, double b)
    {
        head.setLocation(a,b);
        Snek.set(Snek.size()-1, head);
    }
    public void setBodyLocation(double a,double b,int index)
    {
        bodyPart=new Point2D.Double(a,b);
        Snek.set(index, bodyPart);
    }
    public void advanceSnakeBody()
    {
        Snek.remove(0);
        bodyPart=new Point2D.Double();
        bodyPart.setLocation(head);
        Snek.add(Snek.indexOf(head),bodyPart);
    }
    public void growSnake()
    {
        growsnake=true;
    }
    public void addBody()
    {
        bodyPart=new Point2D.Double();
        bodyPart.setLocation(head);
        Snek.add(Snek.indexOf(head),bodyPart);
    }
    public Point2D.Double getHead()
    {
        return head;
    }
    public double getIBodyPartPointX(int index)
    {
        return Snek.get(index).getX();
    }
    public double getIBodyPartPointY(int index)
    {
        return Snek.get(index).getY();
    }
    public double getSnakeHeadX()
    {
        return head.getX();
    }
    public double getSnakeHeadY()
    {
        return head.getY();
    }
    public ArrayList<Point2D.Double> getSnake()
    {
        return Snek;
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
