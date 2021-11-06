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
import javax.swing.JPanel;
/**
 *
 * @author Kpaco
 */
public class Panel extends JPanel implements ActionListener{
   Level test=new Level();
   int delay=50;
   Timer timer;
   boolean running=false;
   boolean check=false;
    Panel(int x, int y)
    {
        test.ConstructLvL(x, y);
        this.setPreferredSize(new Dimension(test.Get_ScreenWidth(),test.Get_ScreenHeight()));
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
    public void draw(Graphics g)
    {
       if(running){
        ///////////////DRAW GRID/////////////   
        for (int i = test.Calc_QuarterScreen(); i <= test.Calc_RightQuarter(); i++) 
        {
            g.drawLine(i*test.Get_Gameunits(),0,i*test.Get_Gameunits(),test.Get_ScreenHeight()*test.Get_Gameunits());
        }
        for (int x = 0; x < test.Screen_Height/test.Get_Gameunits()-1; x++) 
        {
            g.drawLine(test.Calc_QuarterScreen()*test.Get_Gameunits(),x*test.Get_Gameunits(),test.Calc_RightQuarter()*test.Get_Gameunits(),x*test.Get_Gameunits());
        }
        
        /////////////////////////////////////
        
           for (int i = 0; i < 8; i=i+2) 
           {
               int x=(int)test.GetWallPoint(i).getX();
               int y=(int)test.GetWallPoint(i).getY();
              if(test.GetWallPoint(i).getY()==test.GetWallPoint(i+1).getY())
              {
                  do
                  {
                      
                     g.fillRect(x,y,test.Get_Gameunits(),test.Get_Gameunits());
                     x=x+(1*test.Get_Gameunits());
                  }
                  while(x!=test.GetWallPoint(i+1).getX());
              }
             
              else if(test.GetWallPoint(i).getX()==test.GetWallPoint(i+1).getX())
              {
                  do
                  {
                     g.fillRect(x,y,test.Get_Gameunits(),test.Get_Gameunits());
                     y=y+(1*test.Get_Gameunits());
                     
                  }
                  while(y!=test.GetWallPoint(i+1).getY());
              }
           }
        
        
        //draw apple
        g.setColor(Color.red);
        g.fillOval((int)test.Get_appleX(), (int)test.Get_appleY(), test.Get_Gameunits(), test.Get_Gameunits());
        
       ////////////////////DRAW SNAKE/////////
        g.setColor(Color.green);
        String imgurl2="F:\\letöltések\\gentle.png";
        image2=Toolkit.getDefaultToolkit().getImage(imgurl2);
        g.fillRect((int) test.getSnakeHeadX(), (int) test.getSnakeHeadY(), test.Get_Gameunits(), test.Get_Gameunits());
        //g.drawImage(image2,(int) test.getSnakeHeadX(), (int) test.getSnakeHeadY(), test.Get_Gameunits(), test.Get_Gameunits(),test);
        String imgurl="F:\\letöltések\\better.png";
        
        image = Toolkit.getDefaultToolkit().getImage(imgurl);
        for (int i = test.getSnakeSize()-2; i >= 0; i--) 
        {
                g.setColor(new Color(200,10,0));
                g.fillRect((int) test.getBodyX(i), (int) test.getBodyY(i), test.Get_Gameunits(), test.Get_Gameunits());
               // g.drawImage(image, (int)test.getBodyX(i), (int) test.getBodyY(i), test.Get_Gameunits(), test.Get_Gameunits(), test);
        }
        /////////////////////////////////////
       }
       else
       {
           g.setFont(new Font("TimesRoman", Font.PLAIN, 70)); 
           g.drawString("ABSOLUTE RETARD", 1920/2, 1080/2);
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

