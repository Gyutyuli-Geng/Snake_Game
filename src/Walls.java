/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.*;
import java.lang.Math;
/**
 * 
 *
 * @author Kpaco
 */
public class Walls {
    
    ArrayList<Point2D.Double>Wall=new ArrayList<Point2D.Double>();
    Point2D.Double wallStart;
    Point2D.Double wallEnd;
    
    int distance;
    public Walls()
    {
      
    }
    public void createWall(double UNIT_SIZE,double quarterScreen,double rightQuarter,double screenHeight)
    {
        //TODO:
        //FIX THIS FUCKING SHITE HEIGHT COORDS
        double x=Math.round(screenHeight/UNIT_SIZE);
        double y=quarterScreen*UNIT_SIZE;
        while(y<rightQuarter*UNIT_SIZE)
        {
            y=y+UNIT_SIZE;
        }
        for (int i = 0; i < 2; i++) 
        {
            Wall.add(wallStart=new Point2D.Double(quarterScreen*UNIT_SIZE,i*(x*UNIT_SIZE)));
            Wall.add(wallEnd=new Point2D.Double(y,i*(x*UNIT_SIZE)));
        }
        for (int i = 0; i < 2; i++) 
        {
            if(i==1)y=quarterScreen*UNIT_SIZE;
            Wall.add(wallStart=new Point2D.Double(y,0));
            Wall.add(wallEnd=new Point2D.Double(y,x*UNIT_SIZE));
        }
    }
    public void addWall(double x, double y,double UNIT_SIZE,double quarterScreen,double rightQuarter,double screenHeight)
    {
        for (double i = quarterScreen*UNIT_SIZE; i < rightQuarter*UNIT_SIZE; i=i+UNIT_SIZE)
        {
            if(x>i&&x<i+UNIT_SIZE)
            {
                x=i;
                break;
            }
        }
        for (double i = 0; i < screenHeight; i+=UNIT_SIZE) 
        {
            if(y>i && y<i+UNIT_SIZE)
            {
                y=i;
                break;
            }
            
        }
       
    }
        
    public Point2D.Double getArrayPoint(int i)
    {
        return Wall.get(i);
    }

}
