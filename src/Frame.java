/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author Kpaco
 */
public class Frame extends JFrame{
    Frame()
    {
        
        GraphicsDevice gDev;
        GraphicsEnvironment gEnv=GraphicsEnvironment.getLocalGraphicsEnvironment();
        gDev=gEnv.getDefaultScreenDevice();
      //  MainMenu menu=new MainMenu(gDev.getDisplayMode().getWidth(),gDev.getDisplayMode().getHeight());
        
       /* JButton start=new JButton();
        menu.add(start);/*/
        this.add(new Panel(1920,1080));
        this.setTitle("snek");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.pack();
       // this.setUndecorated(true);
       //gDev.setFullScreenWindow(this);
        this.setVisible(true);
        //this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
    }
    
}
