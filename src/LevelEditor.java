/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kpaco
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.Timer;
public class LevelEditor extends JPanel implements ActionListener{
   Level test=new Level();
   int delay=1;
   Timer timer;
   boolean clicked=false;
   LevelEditor(int x, int y)
   {
        test.ConstructLvL(x, y);
        this.setPreferredSize(new Dimension(x,y));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addMouseListener(new MyMouesAdapter());
        //this.addKeyListener(new LevelEditor.MyKeyAdapter());
    
   }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        draw(g);
    }
    public void drawWall(Graphics g)
    {   
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.red);
        for (int i = 0; i < 8; i=i+2) 
           {
               double x=test.GetWallPoint(i).getX();
               double y=test.GetWallPoint(i).getY();
              if(test.GetWallPoint(i).getY()==test.GetWallPoint(i+1).getY())
              {
                 do
                  {
                     g2.fill(new Rectangle2D.Double(x,y,test.Get_Gameunits(),test.Get_Gameunits()));
                     x=x+test.Get_Gameunits();
                 }
                  while(x!=test.GetWallPoint(i+1).getX() || x<test.GetWallPoint(i+1).getX());
                  g2.fill(new Rectangle2D.Double(x,y,test.Get_Gameunits(),test.Get_Gameunits()));
                  g2.fill(new Rectangle2D.Double(test.GetWallPoint(i+1).getX(),y,test.Get_Gameunits(),test.Get_Gameunits()));
              }
             
              else if(test.GetWallPoint(i).getX()==test.GetWallPoint(i+1).getX())
              {
                  do
                  {
                     g2.fill(new Rectangle2D.Double(x,y,test.Get_Gameunits(),test.Get_Gameunits()));
                     y=y+(1*test.Get_Gameunits());
                  }
                  while(y!=test.GetWallPoint(i+1).getY() || y<test.GetWallPoint(i+1).getY());
                  g2.fill(new Rectangle2D.Double(y,x,test.Get_Gameunits(),test.Get_Gameunits()));
                  g2.fill(new Rectangle2D.Double(test.GetWallPoint(i+1).getY(),x,test.Get_Gameunits(),test.Get_Gameunits()));
              }
           }
       
    }
    public void drawWallPoints(Graphics g)
    {   if(clicked){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.red);
        int wallsize=test.Wall.Wall.size();
        double x=test.GetWallPoint(wallsize-1).getX();
        double y;
        if(wallsize%2==0)
        {
            for (int i = 8; i < test.Wall.Wall.size(); i+=2) {
                x=test.GetWallPoint(i).getX();
                y=test.GetWallPoint(i).getY();
                if(test.GetWallPoint(i).getY()==test.GetWallPoint(i+1).getY())
                {
                    do
                    {
                        g2.fill(new Rectangle2D.Double(x,y,test.Get_Gameunits(),test.Get_Gameunits()));
                        x=x+test.Get_Gameunits();
                    }
                  while(x!=test.GetWallPoint(i+1).getX() || x<test.GetWallPoint(i+1).getX());
                  g2.fill(new Rectangle2D.Double(x,y,test.Get_Gameunits(),test.Get_Gameunits()));
                  g2.fill(new Rectangle2D.Double(test.GetWallPoint(i+1).getX(),y,test.Get_Gameunits(),test.Get_Gameunits()));
              }
             
              else if(test.GetWallPoint(i).getX()==test.GetWallPoint(i+1).getX())
              {
                  do
                  {
                     g2.fill(new Rectangle2D.Double(x,y,test.Get_Gameunits(),test.Get_Gameunits()));
                     y=y+(1*test.Get_Gameunits());
                  }
                  while(y!=test.GetWallPoint(i+1).getY() || y<test.GetWallPoint(i+1).getY());
                  g2.fill(new Rectangle2D.Double(y,x,test.Get_Gameunits(),test.Get_Gameunits()));
                  g2.fill(new Rectangle2D.Double(test.GetWallPoint(i+1).getY(),x,test.Get_Gameunits(),test.Get_Gameunits()));
              }
            }
        }
        if(test.Wall.Wall.size()%2!=0)
        {
            x=test.GetWallPoint(wallsize-1).getX();
            y=test.GetWallPoint(wallsize-1).getY();
            g2.fill(new Rectangle2D.Double(x,y,test.Get_Gameunits(),test.Get_Gameunits()));
        }
        /*/for (int i = 8; i < test.Wall.Wall.size(); i++) {
            double x=test.GetWallPoint(i).getX();
            double y=test.GetWallPoint(i).getY();
            g2.fill(new Rectangle2D.Double(x,y,test.Get_Gameunits(),test.Get_Gameunits()));
        }/*/
        clicked=false;
    }
    }
    public void drawGrid(Graphics g)
    {
        Graphics2D g2=(Graphics2D) g;
        
        g2.setColor(Color.red);
        for (double i = test.Calc_QuarterScreen(); i <= test.Calc_RightQuarter(); i++) 
        {
            g2.draw(new Line2D.Double(i*test.Get_Gameunits(),0,i*test.Get_Gameunits(),test.Get_ScreenHeight()*test.Get_Gameunits()));
        }
        for (double x = 0; x < test.Screen_Height/test.Get_Gameunits()-1; x++) 
        {
            g2.draw(new Line2D.Double(test.Calc_QuarterScreen()*test.Get_Gameunits(),x*test.Get_Gameunits(),test.Calc_RightQuarter()*test.Get_Gameunits(),x*test.Get_Gameunits()));
        }
        
    }
    public void draw(Graphics g)
    {
        drawGrid(g);
        drawWall(g);
        drawWallPoints(g);
    }
    public void SaveLevel(String name)
    {
        try{
        File obj=new File(name);
        if(obj.createNewFile())
        {
            //show message stating file was created
        }
        else
        {
            //file exists
            //do rest
        }
        }
        catch(IOException e)
        {
        
        }   
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
       
    }
    public class MyMouesAdapter extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            double mouseX=Math.floor(e.getX()/test.Get_Gameunits());
            double mouseY=Math.floor(e.getY()/test.Get_Gameunits());
            System.out.print(mouseX+"....."+mouseY+" ");
            test.Wall.addWall(mouseX, mouseY,test.Get_Gameunits(), test.Calc_QuarterScreen(), test.Calc_RightQuarter(), test.Get_ScreenHeight());
            clicked=true;
            repaint();
        }
    }
}

    

