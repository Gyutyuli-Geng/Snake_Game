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
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author Kpaco
 */
public class Frame extends JFrame{
    Frame(String paneltype,int width,int height,int GameSpeed,String FileName,List<JCheckBox> CheckBoxList,String SelectedSkin,int UNIT_SIZE)
    {
        
        GraphicsDevice gDev;
        GraphicsEnvironment gEnv=GraphicsEnvironment.getLocalGraphicsEnvironment();
        gDev=gEnv.getDefaultScreenDevice();
        boolean HardMode=false;
        boolean AiMode=false;
        for (int i = 0; i < CheckBoxList.size(); i++) 
        {
            System.out.print(CheckBoxList.get(i).isSelected());
            if(CheckBoxList.get(i).getText()=="Hard mode" && CheckBoxList.get(i).isSelected()) HardMode=true;
            if(CheckBoxList.get(i).getText()=="AiMode" && CheckBoxList.get(i).isSelected()) AiMode=true;
        }
        switch (paneltype){
            case "edit":
                this.add(new LevelEditor(width,height,FileName));
                break;
            case "game":
                this.add(new Panel(width,height,GameSpeed,FileName,HardMode,AiMode,SelectedSkin,UNIT_SIZE));
                break;
            default:
                this.add(new Panel(width,height,GameSpeed,FileName,HardMode,AiMode,SelectedSkin,UNIT_SIZE));
        }
        //this.add(new LevelEditor(width,height));
        this.setTitle("snek");
        //this.setUndecorated(true);
        
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
