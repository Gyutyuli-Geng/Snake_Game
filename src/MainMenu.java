
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.*;
import java.util.Random;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kpaco
 */
public class MainMenu extends JPanel implements ActionListener{
    
    MainMenu(int x, int y)
    {
        this.setPreferredSize(new Dimension(x,y));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.requestFocusInWindow();
        //this.addKeyListener(new Panel.MyKeyAdapter());   
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    public class MyKeyAdapter extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent e)
        {
          
        }
    }
}
