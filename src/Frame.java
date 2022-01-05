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
    Frame(String paneltype,int width,int height)
    {
        
        /*/GraphicsDevice gDev;
        GraphicsEnvironment gEnv=GraphicsEnvironment.getLocalGraphicsEnvironment();
        gDev=gEnv.getDefaultScreenDevice();/*/
      //  MainMenu menu=new MainMenu(gDev.getDisplayMode().getWidth(),gDev.getDisplayMode().getHeight());
       
       /* JButton start=new JButton();
        menu.add(start);/*/
        switch (paneltype){
            case "edit":
                this.add(new LevelEditor(width,height));
                break;
            case "game":
                this.add(new Panel(width,height));
                break;
            default:
                this.add(new Panel(width,height));
        }
        //this.add(new LevelEditor(width,height));
        this.setTitle("snek");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.pack();
       // this.setUndecorated(true);
       //gDev.setFullScreenWindow(this);
        this.setVisible(true);
        //this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
    }
    
}
