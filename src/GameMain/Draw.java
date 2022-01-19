package GameMain;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kpaco
 */
public class Draw {
    public void drawApple(Graphics g, Level test,Image Apple)
    {
        Graphics2D g2 = (Graphics2D) g;
       // g2.fill(new Ellipse2D.Double(test.Get_appleX(), test.Get_appleY()+test.Get_Hoffset(), test.Get_Gameunits(), test.Get_Gameunits()));
        g2.drawImage(Apple,(int)test.Get_appleX(),(int)test.Get_appleY()+(int)test.Get_Hoffset(),(int)test.Get_Gameunits(),(int)test.Get_Gameunits(),null);
    }
    public void drawSnake(Graphics g, Level test,ArrayList<BufferedImage> Snake)
    {
       Graphics2D g2 = (Graphics2D) g;
       g.setColor(Color.green);
       // g2.fill(new Rectangle2D.Double(test.getSnakeHeadX(), test.getSnakeHeadY()+test.Get_Hoffset(), test.Get_Gameunits(), test.Get_Gameunits()));
       
       g2.drawImage(Snake.get(0),(int)test.getSnakeHeadX(),(int)test.getSnakeHeadY()+(int)test.Get_Hoffset(),(int)test.Get_Gameunits(),(int)test.Get_Gameunits(),null);
       for (int i = test.getSnakeSize()-2; i >= 0; i--) 
       {
            
            g2.setColor(Color.white);
            //g2.fill(new Rectangle2D.Double(test.getBodyX(i),test.getBodyY(i)+test.Get_Hoffset(), test.Get_Gameunits(), test.Get_Gameunits()));             
            if(i==0) g2.drawImage(Snake.get(2),(int)test.getBodyX(i),(int)test.getBodyY(i)+(int)test.Get_Hoffset(), (int)test.Get_Gameunits(), (int)test.Get_Gameunits(),null);
            else g2.drawImage(Snake.get(1),(int)test.getBodyX(i),(int)test.getBodyY(i)+(int)test.Get_Hoffset(), (int)test.Get_Gameunits(), (int)test.Get_Gameunits(),null);
       }
    }
    public void drawWall(Graphics g,Level test,Image Walls)
    {   
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.red);
        for (int i = 0; i < test.Wall.Wall.size(); i=i+2) 
           {
              double x=test.GetWallPoint(i).getX();
              double y=test.GetWallPoint(i).getY();
              if(test.GetWallPoint(i).getY()==test.GetWallPoint(i+1).getY())
              {
                 do
                  {
                   //  g2.fill(new Rectangle2D.Double(x*test.Get_Gameunits(),y*test.Get_Gameunits()+test.Get_Hoffset(),test.Get_Gameunits(),test.Get_Gameunits()));
                     g2.drawImage(Walls,(int)(x*test.Get_Gameunits()),(int)(y*test.Get_Gameunits()+test.Get_Hoffset()),(int)test.Get_Gameunits(),(int)test.Get_Gameunits(),null);
                     if(x<test.GetWallPoint(i+1).getX()) x++;
                     else if(x>test.GetWallPoint(i+1).getX()) x--;
                 }
                  while(x!=test.GetWallPoint(i+1).getX());
                 g2.drawImage(Walls,(int)test.GetWallPoint(i+1).getX()*(int)test.Get_Gameunits(),(int)y*(int)test.Get_Gameunits()+(int)test.Get_Hoffset(),(int)test.Get_Gameunits(),(int)test.Get_Gameunits(),null);
                 /*/ g2.fill(new Rectangle2D.Double(x,y+test.Get_Hoffset(),test.Get_Gameunits(),test.Get_Gameunits()));
                  g2.fill(new Rectangle2D.Double(test.GetWallPoint(i+1).getX(),y+test.Get_Hoffset(),test.Get_Gameunits(),test.Get_Gameunits()));/*/
              }
             
              else if(test.GetWallPoint(i).getX()==test.GetWallPoint(i+1).getX())
              {
                 do
                  {
                     //g2.fill(new Rectangle2D.Double(x*test.Get_Gameunits(),y*test.Get_Gameunits()+test.Get_Hoffset(),test.Get_Gameunits(),test.Get_Gameunits()));
                     g2.drawImage(Walls,(int)(x*test.Get_Gameunits()),(int)(y*test.Get_Gameunits()+test.Get_Hoffset()),(int)test.Get_Gameunits(),(int)test.Get_Gameunits(),null);
                     if(y<test.GetWallPoint(i+1).getY()) y++;
                     else if(y>test.GetWallPoint(i+1).getY()) y--;
                  }
                  while(y!=test.GetWallPoint(i+1).getY());
                 g2.drawImage(Walls,(int)x*(int)test.Get_Gameunits(),(int)(int)test.GetWallPoint(i+1).getY()*(int)test.Get_Gameunits()+(int)test.Get_Hoffset(),(int)test.Get_Gameunits(),(int)test.Get_Gameunits(),null);
                 /*/ g2.fill(new Rectangle2D.Double(y+test.Get_Hoffset(),x,test.Get_Gameunits(),test.Get_Gameunits()));
                  g2.fill(new Rectangle2D.Double(test.GetWallPoint(i+1).getY()+test.Get_Hoffset(),x,test.Get_Gameunits(),test.Get_Gameunits()));/*/
              }
           }
    }
    public void drawWall(Graphics g,Level test)
    {   
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.red);
        for (int i = 0; i < test.Wall.Wall.size(); i=i+2) 
           {
              double x=test.GetWallPoint(i).getX();
              double y=test.GetWallPoint(i).getY();
              if(test.GetWallPoint(i).getY()==test.GetWallPoint(i+1).getY())
              {
                 do
                  {
                     g2.fill(new Rectangle2D.Double(x*test.Get_Gameunits(),y*test.Get_Gameunits(),test.Get_Gameunits(),test.Get_Gameunits()));
                     if(x<test.GetWallPoint(i+1).getX()) x++;
                     else if(x>test.GetWallPoint(i+1).getX()) x--;
                 }
                  while(x!=test.GetWallPoint(i+1).getX());
                 g2.fill(new Rectangle2D.Double(test.GetWallPoint(i+1).getX()*test.Get_Gameunits(),y*test.Get_Gameunits(),test.Get_Gameunits(),test.Get_Gameunits()));
              }
             
              else if(test.GetWallPoint(i).getX()==test.GetWallPoint(i+1).getX())
              {
                 do
                  {
                     g2.fill(new Rectangle2D.Double(x*test.Get_Gameunits(),y*test.Get_Gameunits(),test.Get_Gameunits(),test.Get_Gameunits()));
                    // g2.drawImage(Walls,(int)(x*test.Get_Gameunits()),(int)(y*test.Get_Gameunits()+test.Get_Hoffset()),(int)test.Get_Gameunits(),(int)test.Get_Gameunits(),null);
                     if(y<test.GetWallPoint(i+1).getY()) y++;
                     else if(y>test.GetWallPoint(i+1).getY()) y--;
                  }
                  while(y!=test.GetWallPoint(i+1).getY());
                  g2.fill(new Rectangle2D.Double(x*test.Get_Gameunits(),test.GetWallPoint(i+1).getY()*test.Get_Gameunits(),test.Get_Gameunits(),test.Get_Gameunits()));
                 /*/ g2.fill(new Rectangle2D.Double(y+test.Get_Hoffset(),x,test.Get_Gameunits(),test.Get_Gameunits()));
                  g2.fill(new Rectangle2D.Double(test.GetWallPoint(i+1).getY()+test.Get_Hoffset(),x,test.Get_Gameunits(),test.Get_Gameunits()));/*/
              }
           }
    }
    public void drawLoadScreen(Graphics g,Image img,Level test,Panel lamo)
    {
        Graphics2D g2=(Graphics2D) g;
        int a=lamo.getWidth();
        g2.drawImage(img,0,0,lamo.getWidth(),lamo.getHeight(),lamo);
    }
    public void drawGrid(Graphics g,Level test)
    {
        Graphics2D g2=(Graphics2D) g;
        
        g2.setColor(Color.red);
        for (double i = test.Calc_QuarterScreen(); i <=test.Calc_RightQuarter(); i++) 
        {
            g2.draw(new Line2D.Double(i*test.Get_Gameunits(),0,i*test.Get_Gameunits(),test.Get_ScreenHeight()));
            //g2.drawImage(Bg,(int)i*(int)test.Get_Gameunits() ,(int) 0+(int)test.Get_Hoffset(), (int)i*(int)test.Get_Gameunits(), (int)test.Get_ScreenHeight()+(int)test.Get_Hoffset(), null);
        }
        for (double x = 0; x < test.Screen_Height/test.Get_Gameunits()-1; x++) 
        {
            g2.draw(new Line2D.Double(test.Calc_QuarterScreen()*test.Get_Gameunits(),x*test.Get_Gameunits(),test.Calc_RightQuarter()*test.Get_Gameunits(),x*test.Get_Gameunits()));
            //g2.drawImage(Bg,x*test.Get_Gameunits(), delay, WIDTH, HEIGHT, test)
        }
        
    }
    public void drawBg(Graphics g, Level test, Image Bg)
    {
        Graphics2D g2=(Graphics2D) g;
         for (double x = 0; x <test.Screen_Height/test.Get_Gameunits() ; x++) 
        {
            for (double y = test.Calc_QuarterScreen(); y <test.Calc_RightQuarter() ; y++) 
            {
                g2.drawImage(Bg,(int)(y*test.Get_Gameunits()),(int)(x*test.Get_Gameunits())+(int)test.Get_Hoffset(),(int)test.Get_Gameunits(),(int)test.Get_Gameunits(),null);
            }
        }
    }
    public AffineTransformOp imgRotation(int rotation,BufferedImage img)
    {
        AffineTransform tx = new AffineTransform();
        tx.rotate(rotation*Math.PI/180, img.getWidth() / 2, img.getHeight() / 2);
        AffineTransformOp op = new AffineTransformOp(tx,AffineTransformOp.TYPE_BILINEAR);
        return op;
    }
    
}














/*/
public void drawClick(Graphics g)
    {
        
        if(clicked){
        Point2D.Double Corner=new Point2D.Double();
        MouseCoord.add(new Point2D.Double(mouseX, mouseY));
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.red);
        for (int i = 0; i < MouseCoord.size(); i++)
        {
            g2.fill(new Rectangle2D.Double(MouseCoord.get(i).getX()*test.Get_Gameunits(),MouseCoord.get(i).getY()*test.Get_Gameunits(),test.Get_Gameunits(),test.Get_Gameunits()));
        }
        if(MouseCoord.size()==2)
        {
            if(MouseCoord.get(0).getX()==MouseCoord.get(1).getX() || MouseCoord.get(0).getY()==MouseCoord.get(1).getY())
            {
                test.Wall.Add(MouseCoord, test.Get_Gameunits());
            }
            else
            {
               Corner.setLocation(MouseCoord.get(1).getX(),MouseCoord.get(0).getY());
               MouseCoord.add(Corner);
               test.Wall.Add(MouseCoord, test.Get_Gameunits());
               g2.fill(new Rectangle2D.Double(MouseCoord.get(1).getX()*test.Get_Gameunits(),MouseCoord.get(0).getY()*test.Get_Gameunits(),test.Get_Gameunits(),test.Get_Gameunits()));   
        }
        repaint();
        MouseCoord.clear();
        }
        clicked=false;
        }
    }
/*/