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
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.*;
import java.awt.image.AffineTransformOp;
import java.awt.image.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
/**
 *
 * @author Kpaco
 */
public class Panel extends JPanel implements ActionListener {
    
   Level test=new Level();
   int delay=40;
   Timer timer;
   boolean running=false;
   boolean HardMode=false;
   boolean AiMode=false;
   int color=0;
   ArrayList<BufferedImage>SnakeIMG=new ArrayList<BufferedImage>();
   JLabel label = new JLabel();
   String datapath = System.getProperty("user.dir")+"/Skins/";
   Toolkit t=Toolkit.getDefaultToolkit();  
   Image Apple;
   BufferedImage Snakehead;
   BufferedImage Snakebody;
   BufferedImage SnakeTail;
   Image Walls;
   Image Bg;
   Draw Render=new Draw();
   Panel(int x, int y,int gameSpeed,String FileName,boolean Hardmode,boolean aiMode,String SelectedSkin,int UNIT_SIZE)
   {
       try
       {
        Apple=t.getImage(datapath+SelectedSkin+"/apple.png");
        Walls=t.getImage(datapath+SelectedSkin+"/wall.png");
        Bg=t.getImage(datapath+SelectedSkin+"/block.png");
        this.Snakehead = ImageIO.read(new File(datapath+SelectedSkin+"/snake_head.png"));
        this.Snakebody = ImageIO.read(new File(datapath+SelectedSkin+"/snake_body.png"));
        this.SnakeTail = ImageIO.read(new File(datapath+SelectedSkin+"/snake_tail.png"));
        SnakeIMG.add(Snakehead);
        SnakeIMG.add(Snakebody);
        SnakeIMG.add(SnakeTail);
       }
       catch(IOException e){}
        if(FileName==null) test.Set_Gameunits(UNIT_SIZE);
        HardMode=Hardmode;
        AiMode=aiMode;
        delay=gameSpeed;
        test.ConstructLvL(x, y,FileName);
        this.setPreferredSize(new Dimension(x,y));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new MyKeyAdapter());
        start();
   }
    static Image image;
    static Image image2;
    public void start()
    {
        do
        {
            test.GenApple();
        }
        while(test.checkAppleGenCoords());
        running=true;
        timer=new Timer(delay,this);
        
        timer.start();
        
    }
    public AffineTransformOp imgRotation(double rotation,BufferedImage img)
    {
        double locX=img.getWidth()/2;
        double locY=img.getHeight()/2;
        AffineTransform tx=AffineTransform.getRotateInstance(rotation,locX,locY);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        return op;
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        draw(g);
    }
   
    public void addLabel(int n)
    {
        
        label.setText("High Score: "+n);
        label.setForeground(Color.green);
        int labelX=(int)Math.round(2*test.Get_Gameunits());
        int labelY=(int)Math.round(2*test.Get_Gameunits());
        
        label.setBounds(labelX, labelY,10000,10000);
        label.setSize(500,500);
        label.setVisible(true);
         this.add(label);
    }
    public void draw(Graphics g)
    {
       if(running)
       {
        Render.drawBg(g,test,Bg);
        Render.drawWall(g,test,Walls);
        Render.drawApple(g,test,Apple);
        Render.drawSnake(g,test,SnakeIMG);
        addLabel(test.Get_Highscore());
       }
       else
       {
           g.setFont(new Font("TimesRoman", Font.PLAIN, 70));
       }
    }

    
    @Override
    public void setLayout(LayoutManager mgr) {
        super.setLayout(null); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(running)
        {
            test.Move();
            if(test.checkApple()&&HardMode) 
            {
                delay-=20;
                timer.setDelay(delay);
                //finish randomized delay time
            }
            for (int i = 0; i < test.getSnakeSize()-2; i++) 
            {
              if(test.checkCollision(i)) running=false;
            }
            if(test.checkWallCollision()) running=false;
        }
        repaint();
    }
    public class MyKeyAdapter extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent e)
        {
            switch(e.getKeyCode())
            {
                case KeyEvent.VK_RIGHT:
                    test.SetSnakeDir('R');
                    break;
                case KeyEvent.VK_DOWN:
                    test.SetSnakeDir('D');
                    break;
                case KeyEvent.VK_LEFT:
                    test.SetSnakeDir('L');
                    break;
                case KeyEvent.VK_UP:
                    test.SetSnakeDir('U');
                    break;
            }
        }
    }
    
    
    
    
}

