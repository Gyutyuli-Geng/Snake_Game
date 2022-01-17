/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kpaco
 */

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
   LevelEditor(int x, int y,String FileName)
   {
        SaveAction=new SaveAction();
        test.ConstructLvL(x, y,FileName);
        label.getInputMap().put(KeyStroke.getKeyStroke('s'), "SaveAction");
        label.getActionMap().put("SaveAction", SaveAction);
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
    public void drawWall(Graphics g)
    {   
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.red);
        for (int i = 0; i < test.Wall.Wall.size(); i=i+2) 
           {
              double x=test.GetWallPoint(i).getX();
              double y=test.GetWallPoint(i).getY();
              if(test.GetWallPoint(i).getY()==test.GetWallPoint(i+1).getY())
              {
                 do
                  {
                     g2.fill(new Rectangle2D.Double(x*test.Get_Gameunits(),y*test.Get_Gameunits(),test.Get_Gameunits(),test.Get_Gameunits()));
                     if(x<test.GetWallPoint(i+1).getX()) x++;
                     else if(x>test.GetWallPoint(i+1).getX()) x--;
                     
                 }
                  while(x!=test.GetWallPoint(i+1).getX());
                  g2.fill(new Rectangle2D.Double(x*test.Get_Gameunits(),y*test.Get_Gameunits(),test.Get_Gameunits(),test.Get_Gameunits()));
                  g2.fill(new Rectangle2D.Double(test.GetWallPoint(i+1).getX()*test.Get_Gameunits(),y*test.Get_Gameunits(),test.Get_Gameunits(),test.Get_Gameunits()));
              }
             
              else if(test.GetWallPoint(i).getX()==test.GetWallPoint(i+1).getX())
              {
                  do
                  {
                     g2.fill(new Rectangle2D.Double(x*test.Get_Gameunits(),y*test.Get_Gameunits(),test.Get_Gameunits(),test.Get_Gameunits()));
                     if(y<test.GetWallPoint(i+1).getY()) y++;
                     else if(y>test.GetWallPoint(i+1).getY()) y--;
                  }
                  while(y!=test.GetWallPoint(i+1).getY());
                  //g2.fill(new Rectangle2D.Double(y,x,test.Get_Gameunits(),test.Get_Gameunits()));
                  //g2.fill(new Rectangle2D.Double(test.GetWallPoint(i+1).getY(),x,test.Get_Gameunits(),test.Get_Gameunits()));
              }
           }
       
    }
    
    public double CalcDistance(Point2D x, Point2D y)
    {
        return Math.sqrt(Math.pow(y.getX()-x.getY(),2)+Math.pow(y.getY()-x.getY(),2));
    }
    public void drawClick(Graphics g)
    {
        
        if(clicked){
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
        repaint();
        MouseCoord.clear();
        }
        clicked=false;
        }
    }
    
    public void drawGrid(Graphics g)
    {
        Graphics2D g2=(Graphics2D) g;
        g2.setColor(Color.red);
        for (double i = test.Calc_QuarterScreen(); i <= test.Calc_RightQuarter(); i++) 
        {
            g2.draw(new Line2D.Double(i*test.Get_Gameunits(),0,i*test.Get_Gameunits(),test.Get_ScreenHeight()*test.Get_Gameunits()));
        }
        for (double x = 0; x < test.Screen_Height/test.Get_Gameunits()-1; x++) 
        {
            g2.draw(new Line2D.Double(test.Calc_QuarterScreen()*test.Get_Gameunits(),x*test.Get_Gameunits(),test.Calc_RightQuarter()*test.Get_Gameunits(),x*test.Get_Gameunits()));
        }
        
    }
    public void draw(Graphics g)
    {
        Render.drawGrid(g, test);
        Render.drawWall(g, test);
        if(Render.drawClick(g, clicked, MouseCoord, mouseX, mouseY, test))
        {
            
            clicked=false;
        }
    }
    public void callRepaint()
    {
        repaint();
    }
    public void SaveLevel(String name)
    {
        try{
        File obj=new File(name);
        if(obj.createNewFile())
        {
            //show message stating file was created
        }
        else
        {
            //file exists
            //do rest
        }
        }
        catch(IOException e)
        {
        
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
            test.Save();
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
            System.out.print(mouseX+"....."+mouseY+" ");
            
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
                    test.Save();
                    label.setText("saved");
            }
        }
    }
    
}

    

