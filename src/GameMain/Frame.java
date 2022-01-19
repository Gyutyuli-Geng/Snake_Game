package GameMain;

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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
/**
 *
 * @author Kpaco
 */
public class Frame extends JFrame{
   public Frame(String paneltype,int width,int height,int GameSpeed,String FileName,List<JCheckBox> CheckBoxList,String SelectedSkin,int UNIT_SIZE,String ButtonState)
    {
        
        GraphicsDevice gDev;
        GraphicsEnvironment gEnv=GraphicsEnvironment.getLocalGraphicsEnvironment();
        gDev=gEnv.getDefaultScreenDevice();
        boolean HardMode=false;
        boolean AiMode=false;
        
        for (int i = 0; i < CheckBoxList.size(); i++) 
        {
            System.out.print(CheckBoxList.get(i).isSelected());
            if(CheckBoxList.get(i).getText()=="Hard_mode" && CheckBoxList.get(i).isSelected()) HardMode=true;
            if(CheckBoxList.get(i).getText()=="AI_mode" && CheckBoxList.get(i).isSelected()) AiMode=true;
        }
        switch(ButtonState){
            case "FullScreen":
                gDev.setFullScreenWindow(this);
                break;
            case "Windowed_Borderless":
                this.setUndecorated(true);
                break;
        }
                    
        LevelEditor Edit=new LevelEditor(width,height,FileName,UNIT_SIZE);
        Panel panel=new Panel(width,height,GameSpeed,FileName,HardMode,AiMode,SelectedSkin,UNIT_SIZE);
        switch (paneltype){
            case "edit":
                this.add(Edit);
                break;
            case "game":
                this.add(panel);
                break;
            default:
                this.add(panel);
        }
        //this.add(new LevelEditor(width,height));
        this.setTitle("snek");
        //this.setUndecorated(true);
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.pack();
       // this.setUndecorated(true);
       //gDev.setFullScreenWindow(this);
        this.setVisible(true);
        //this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                e.getWindow().removeAll();
                e.getWindow().dispose();  
                Edit.removeAll();
                panel.invalidate();
                panel.removeAll();
                panel.timer.stop();
                panel.setCloseState(true);
                panel.bgMusic.stopThread();  
            }
            public void windowOpened(WindowEvent e)
            {
                if(paneltype=="edit")
                {
                panel.invalidate();
                panel.removeAll();
                panel.timer.stop();
                panel.setCloseState(true);
                panel.bgMusic.stopThread();  
                }
            }
        });
    }
    
}
