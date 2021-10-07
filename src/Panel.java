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
    Level test=new Level(60,60);
    static final int screen_width=600;
    static final int screen_height=600;
   int delay=75;
   Timer timer;
    Panel()
    {
        this.setPreferredSize(new Dimension(test.Get_Gameunits(),test.Get_Gameunits()));
        this.setBackground(Color.black);
        this.setFocusable(true);
        
    }
    public void start()
    {
        test.GenApple();
        timer=new Timer(delay,this);
        timer.start();
    }
    public void paint(Graphics g){
    super.paintComponent(g);
    draw(g);
    }
    public void draw(Graphics g)
    {
        for (int i = 0; i < screen_height/test.Get_Gameunits(); i++) 
        {
            g.drawLine(i*test.Get_Gameunits(),0,i*test.Get_Gameunits(),test.Get_Gameunits());
        }
    
    }
    public void actionPerformed(ActionEvent e)
    {
        
    }
}

