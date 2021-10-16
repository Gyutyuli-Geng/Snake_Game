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
import javax.swing.JPanel;
/**
 *
 * @author Kpaco
 */
public class Panel extends JPanel implements ActionListener{
   Level test=new Level(1920,1080);
   int delay=75;
   Timer timer;
   boolean running=false;
    Panel()
    {
        this.setPreferredSize(new Dimension(test.Get_ScreenWidth(),test.Get_ScreenHeight()));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new MyKeyAdapter());
        start();
    }
    
    public void start()
    {
        test.GenApple();
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
        for (int i = test.Calc_QuarterScreen(); i <= test.Calc_RightQuarter(); i++) 
        {
            
            g.drawLine(i*test.Get_Gameunits(),0,i*test.Get_Gameunits(),test.Get_ScreenHeight()*test.Get_Gameunits());
        }
        for (int x = 0; x <= test.Get_ScreenHeight(); x++) 
        {
            g.drawLine(test.Calc_QuarterScreen()*test.Get_Gameunits(),x*test.Get_Gameunits(),test.Calc_RightQuarter()*test.Get_Gameunits(),x*test.Get_Gameunits());
        }
        
        //draw apple
        g.setColor(Color.red);
        g.fillOval(test.Get_appleX(), test.Get_appleY(), test.Get_Gameunits(), test.Get_Gameunits());
        
        int x[]=test.Get_MapX();
        int y[]=test.Get_MapY();
        g.setColor(Color.green);
        g.fillRect((int) test.getSnakeHeadX(),0, test.Get_Gameunits(), test.Get_Gameunits());
        int a=test.getDistancebody()-1;
        for (int i = 0; i < 3; i++) 
        {
                g.setColor(new Color(45,180,0));
                g.fillRect((int) test.getSnakeTailX()+(a*test.Get_Gameunits()),0, test.Get_Gameunits(), test.Get_Gameunits());
                a--;
        }
        
       }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running)
        {
            test.Move();
        }
        repaint();
    }
    public class MyKeyAdapter extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent e)
        {
            
        }
    }
    
    
    
    
}

