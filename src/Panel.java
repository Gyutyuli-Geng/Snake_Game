/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.*;
import javax.swing.JPanel;
/**
 *
 * @author Kpaco
 */
public class Panel extends JPanel implements ActionListener{
   Level test=new Level();
   int delay=40;
   Timer timer;
   boolean running=false;
   int color=0;
   Panel(int x, int y)
   {
        test.ConstructLvL(x, y);
        this.setPreferredSize(new Dimension(x,y));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new MyKeyAdapter());
        start();
   }
    static Image image;
    static Image image2;
    public void start()
    {
        do
        {
            test.GenApple();
        }
        while(test.checkAppleGenCoords());
        running=true;
        timer=new Timer(delay,this);
        timer.start();
        
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        draw(g);
    }
    public void drawApple(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.red);
        g2.fill(new Ellipse2D.Double(test.Get_appleX(), test.Get_appleY(), test.Get_Gameunits(), test.Get_Gameunits()));
        
    }
    public void drawSnake(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g.setColor(Color.green);
        
        g2.fill(new Rectangle2D.Double(test.getSnakeHeadX(), test.getSnakeHeadY(), test.Get_Gameunits(), test.Get_Gameunits()));
      
        for (int i = test.getSnakeSize()-2; i >= 0; i--) 
        {
                g2.setColor(Color.white);
                g2.fill(new Rectangle2D.Double(test.getBodyX(i),test.getBodyY(i), test.Get_Gameunits(), test.Get_Gameunits()));
        }
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
                     y=y+test.Get_Gameunits();
                  }
                  while(y!=test.GetWallPoint(i+1).getY() || y<test.GetWallPoint(i+1).getY());
                  g2.fill(new Rectangle2D.Double(y,x,test.Get_Gameunits(),test.Get_Gameunits()));
                  g2.fill(new Rectangle2D.Double(test.GetWallPoint(i+1).getY(),x,test.Get_Gameunits(),test.Get_Gameunits()));
              }
           }
        /*/for (int i = 8; i < test.Wall.Wall.size(); i++) {
            double x=test.GetWallPoint(i).getX();
            double y=test.GetWallPoint(i).getY();
            g2.fill(new Rectangle2D.Double(x,y,test.Get_Gameunits(),test.Get_Gameunits()));
        }/**/
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
    public void getMouseClick(int x, int y)
    {
      //test.Wall.addWall(x, y);
      System.out.println("bigman: "+x+"anotherbigman"+y);
    }
    public void draw(Graphics g)
    {
       if(running)
       {
        drawGrid(g);
        drawWall(g);
        drawApple(g);
        drawSnake(g);
       }
       else
       {
           g.setFont(new Font("TimesRoman", Font.PLAIN, 70));
       }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running)
        {
            test.Move();
            test.checkApple();
            for (int i = 0; i < test.getSnakeSize()-2; i++) 
            {
              if(test.checkCollision(i)) running=false;
            }
            if(test.checkWallCollision()) running=false;
        }
        repaint();
    }
    public class MyKeyAdapter extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent e)
        {
            switch(e.getKeyCode())
            {
                case KeyEvent.VK_RIGHT:
                    test.SetSnakeDir('R');
                    break;
                case KeyEvent.VK_DOWN:
                    test.SetSnakeDir('D');
                    break;
                case KeyEvent.VK_LEFT:
                    test.SetSnakeDir('L');
                    break;
                case KeyEvent.VK_UP:
                    test.SetSnakeDir('U');
                    break;
            }
        }
    }
    
    
    
    
}

