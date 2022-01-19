package GameMain;

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
        double y=quarterScreen;
        while(y<rightQuarter)
        {
           y++;
        }
        y-=1;
        for (int i = 0; i < 2; i++) 
        {
            Wall.add(wallStart=new Point2D.Double(quarterScreen,i*(x)));
            Wall.add(wallEnd=new Point2D.Double(y,i*(x)));
        }
        for (int i = 0; i < 2; i++) 
        {
            if(i==1)y=quarterScreen;
            Wall.add(wallStart=new Point2D.Double(y,0));
            Wall.add(wallEnd=new Point2D.Double(y,x));
        }
    }
   
    public void deleteWall(int index)
    {
        if(index==-1) return;
        Wall.remove(index);
        Wall.remove(index);
    }
    public void Add(ArrayList<Point2D.Double>Coords, double UNIT_SIZE)
    {
        if(Coords.size()==3)
        {
            for (int i = 0; i < 2; i++) {
                Wall.add(wallStart=new Point2D.Double(Coords.get(i).getX(),Coords.get(i).getY()));
                Wall.add(wallEnd=new Point2D.Double(Coords.get(2).getX(),Coords.get(2).getY()));
            }
        }
        else{
        Wall.add(wallStart=new Point2D.Double(Coords.get(0).getX(),Coords.get(0).getY()));
        Wall.add(wallEnd=new Point2D.Double(Coords.get(1).getX(),Coords.get(1).getY()));
        }
    }
    public Point2D.Double getArrayPoint(int i)
    {
        return Wall.get(i);
    }

}
