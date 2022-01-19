package GameMain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kpaco
 */

import GameMain.Level;
import GameMain.Draw;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class LevelEditor extends JPanel{
   Level test=new Level();
   Action SaveAction;
   int delay=1;
   Timer timer;
   boolean clicked=false;
   double mouseX;
   Draw Render=new Draw();
   double mouseY;
   JLabel label = new JLabel();
   String State="Press S to save";
   ArrayList<Point2D.Double>MouseCoord=new ArrayList<Point2D.Double>();
   LevelEditor(int x, int y,String FileName,int UNIT_SIZE)
   {
        SaveAction=new SaveAction();
        if(FileName==null) test.Set_Gameunits(UNIT_SIZE);
        test.ConstructLvL(x, y,FileName);
        addLabel(State);
        this.setPreferredSize(new Dimension(x,y));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addMouseListener(new MyMouesAdapter());
        this.addKeyListener(new LevelEditor.MyKeyAdapter());
        //this.addKeyListener(new LevelEditor.MyKeyAdapter());
   }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        draw(g);
    }
    public boolean drawClick(Graphics g,boolean clicked,ArrayList<Point2D.Double>MouseCoord,double mouseX,double mouseY,Level test)
    {
        
        if(!clicked) return false;
        Point2D.Double Corner=new Point2D.Double();
        MouseCoord.add(new Point2D.Double(mouseX, mouseY));
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.red);
        for (int i = 0; i < MouseCoord.size(); i++)
        {
            g2.fill(new Rectangle2D.Double(MouseCoord.get(i).getX()*test.Get_Gameunits(),MouseCoord.get(i).getY()*test.Get_Gameunits(),test.Get_Gameunits(),test.Get_Gameunits()));
        }
        if(MouseCoord.size()==2)
        {
            if(MouseCoord.get(0).getX()==MouseCoord.get(1).getX() || MouseCoord.get(0).getY()==MouseCoord.get(1).getY())
            {
                test.Wall.Add(MouseCoord, test.Get_Gameunits());
            }
            else
            {
               Corner.setLocation(MouseCoord.get(1).getX(),MouseCoord.get(0).getY());
               MouseCoord.add(Corner);
               test.Wall.Add(MouseCoord, test.Get_Gameunits());
               g2.fill(new Rectangle2D.Double(MouseCoord.get(1).getX()*test.Get_Gameunits(),MouseCoord.get(0).getY()*test.Get_Gameunits(),test.Get_Gameunits(),test.Get_Gameunits()));   
        }
        MouseCoord.clear();
        repaint();
        }
        
        return true;
    }
    public void draw(Graphics g)
    {
        Render.drawGrid(g, test);
        Render.drawWall(g, test);
        if(drawClick(g, clicked, MouseCoord, mouseX, mouseY, test))
        {
            clicked=false;
        }
    }
 
    public void addLabel(String state)
    {
        label.setText(state);
        label.setForeground(Color.green);
        int labelX=(int)Math.round(2*test.Get_Gameunits());
        int labelY=(int)Math.round(2*test.Get_Gameunits());
        label.setBounds(labelX, labelY,10000,10000);
        label.setSize(500,500);
        label.setVisible(true);
        this.add(label);
    }
    
    public class SaveAction extends AbstractAction
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            label.setText("Saved");
            //test.Save();
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    public class MyMouesAdapter extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            mouseX=Math.floor(e.getX()/test.Get_Gameunits());
            mouseY=Math.floor(e.getY()/test.Get_Gameunits());
            if(e.getButton()==MouseEvent.BUTTON3)
            {
                test.Wall.deleteWall(test.CheckMouseClickForDelete(mouseX, mouseY));
            }
            else if(e.getButton()==MouseEvent.BUTTON1)
            {
                clicked=true;
            }
            repaint();
        }
    }
    public class MyKeyAdapter extends KeyAdapter
    {
        
        @Override
        public void keyPressed(KeyEvent e)
        {
            switch(e.getKeyCode())
            {
                case KeyEvent.VK_S:
                    
                    String Savename=JOptionPane.showInputDialog("enter save name","SAVENAME");
                    test.Save(Savename);
                    label.setText("saved");
            }
        }
    }
    
}

    

