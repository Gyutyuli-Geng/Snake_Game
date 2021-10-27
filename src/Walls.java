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
 *
 * @author Kpaco
 */
public class Walls {
    
    ArrayList<Point>Wall=new ArrayList<Point>();
    Point wallStart;
    Point wallEnd;
    int distance;
    public Walls()
    {
      
    }
    public void createWall(int UNIT_SIZE,int quarterScreen,int rightQuarter,int screenHeight)
    {
        //TODO:
        //FIX THIS FUCKING SHITE HEIGHT COORDS
        int x=(screenHeight/UNIT_SIZE)-1;
        int help=quarterScreen*UNIT_SIZE;
        for (int i = 0; i < 2; i++) 
        {
            Wall.add(wallStart=new Point(quarterScreen*UNIT_SIZE,i*(x*UNIT_SIZE)));
            Wall.add(wallEnd=new Point(rightQuarter*UNIT_SIZE,i*(x*UNIT_SIZE)));
        }
        for (int i = 0; i < 2; i++) 
        {
            if(i==1)help=rightQuarter*UNIT_SIZE;
            Wall.add(wallStart=new Point(help,0));
            Wall.add(wallEnd=new Point(help,x*UNIT_SIZE));
        }
    }
    public void addWall()
    {
        
    }
    public int getPointDistnaceX(int i)
    {
        distance=(int)Math.sqrt(Math.pow((Wall.get(i+1).getX()-Wall.get(i).getX()),2)+Math.pow((Wall.get(i+1).getY()-Wall.get(i).getY()),2));
        return distance;
    }
    public int getPointDistnaceY(int i)
    {
        distance=(int)Math.sqrt(Math.pow((Wall.get(i+1).getX()-Wall.get(i).getX()),2)+Math.pow((Wall.get(i+1).getY()-Wall.get(i).getY()),2));
        return distance;
    }
    public Point getArrayPoint(int i)
    {
        return Wall.get(i);
    }
}
