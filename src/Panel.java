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
   //GraphicsDevice gDev;
   
    Panel()
    {
        this.setPreferredSize(new Dimension(test.Get_ScreenWidth(),test.Get_ScreenHeight()));
        this.setBackground(Color.black);
        this.setFocusable(true);
        
        start();
    }
    public void start()
    {
        test.GenApple();
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
       
        for (int i = test.Calc_QuarterScreen(); i <= test.Calc_RightQuarter(); i++) 
        {
            
            g.drawLine(i*test.Get_Gameunits(),0,i*test.Get_Gameunits(),test.Get_ScreenHeight()*test.Get_Gameunits());
        }
        for (int x = 0; x <= test.Get_ScreenHeight(); x++) 
        {
            g.drawLine(test.Calc_QuarterScreen()*test.Get_Gameunits(),x*test.Get_Gameunits(),test.Calc_RightQuarter()*test.Get_Gameunits(),x*test.Get_Gameunits());
        }
        g.setColor(Color.red);
        g.fillOval(test.Get_appleX(), test.Get_appleY(), test.Get_Gameunits(), test.Get_Gameunits());
        
    }
    public void drawApple(Graphics g)
    {
        
    }
    public void actionPerformed(ActionEvent e)
    {
        
    }
    
    
}

