package GameMain;

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
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.util.Random;
import java.awt.Image;
import static java.awt.SystemColor.info;
import java.awt.Toolkit;
import java.awt.geom.*;
import java.awt.image.AffineTransformOp;
import java.awt.image.*;
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.String.format;
import static java.lang.String.format;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.JPanel;
/**
 *
 * @author Kpaco
 */
public class Panel extends JPanel implements ActionListener {
    
   Level test=new Level();
   int delay=40;
   Timer timer;
   Timer loadtimer;
   boolean running=false;
   boolean HardMode=false;
   boolean AiMode=false;
   int color=0;
   ArrayList<BufferedImage>SnakeIMG=new ArrayList<BufferedImage>();
   JLabel label = new JLabel();
   JLabel currscore = new JLabel();
   Random r=new Random();
   String datapath = System.getProperty("user.dir")+"/Skins/";
   Toolkit t=Toolkit.getDefaultToolkit();  
   Image Apple;
   BufferedImage Snakehead;
   BufferedImage Snakebody;
   BufferedImage SnakeTail;
   Image LoadScreen;
   Image Death;
   Image Walls;
   Image Bg;
   int odelay;
   int scuffedLoad=0;
   boolean drawLoad=true;
   Draw Render=new Draw();
   Sound bgMusic=new Sound();
   aiw AI=new aiw();
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
        LoadScreen = t.getImage(datapath+"/loadscreen.png");
        Death = t.getImage(datapath+"/deathscreen.jpg");
        int a=LoadScreen.getWidth(null);
        SnakeIMG.add(Snakehead);
        SnakeIMG.add(Snakebody);
        SnakeIMG.add(SnakeTail);
       }
       catch(IOException e){}
        if(FileName==null) test.Set_Gameunits(UNIT_SIZE);
        HardMode=Hardmode;
        AiMode=aiMode;
        test.setGamespeed(gameSpeed);
        delay=(int)test.getGamespeed();
        odelay=delay;
        test.ConstructLvL(x, y,FileName);
        this.setPreferredSize(new Dimension(x,y));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new MyKeyAdapter());
        start();
   }
  
    public void start()
    {
        if(AiMode) 
        {
           AI.HamCycle((int)test.Calc_RightQuarter()-(int)test.Calc_QuarterScreen()-2, (int) (Math.round(test.Get_ScreenHeight()/test.Get_Gameunits())-2));
        }
        
        do
        {
            test.GenApple();
        }
        while(test.checkAppleGenCoords());
        running=true;
        timer=new Timer(delay,this);
        timer.start();
        
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        draw(g);
    }
   public char getDir()
    {
        return test.getDir();
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
    public void addCurrscore(int n)
    {
        
        currscore.setText("Current Score: "+n);
        currscore.setForeground(Color.green);
        int labelX=(int)Math.round(2*test.Get_Gameunits());
        int labelY=(int)Math.round(4*test.Get_Gameunits());
        
        currscore.setBounds(labelX, labelY,10000,10000);
        currscore.setSize(500,500);
        currscore.setVisible(true);
        this.add(currscore);
    }
    public void draw(Graphics g)
    {
       if(running)
       {
       
        Render.drawBg(g,test,Bg);
        Render.drawWall(g,test,Walls);
        Render.drawApple(g,test,Apple);
        Render.drawSnake(g,test,SnakeIMG);
        if(drawLoad)  Render.drawLoadScreen(g,LoadScreen,test,this);
       
        addLabel(test.Get_Highscore());
        addCurrscore(test.Get_Currscore());
       }
       else
       {
        Render.drawLoadScreen(g,Death,test,this);
       }
    }
    boolean Isclosing=false;
    public void setCloseState(boolean IsClosing)
    {
       Isclosing=IsClosing;
    }
    
    @Override
    public void setLayout(LayoutManager mgr) {
        super.setLayout(null); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(running)
        {
            
            //AI.butaai((int)test.getSnakeHeadX(), (int)test.getSnakeHeadY());
            test.Move();
            scuffedLoad++;
            if(scuffedLoad==4)
            {
                drawLoad=false;
                if(!Isclosing)
                {bgMusic.run();
                 Isclosing=true;
                }
            }
            if(delay==2000) 
            {
                delay=odelay;
                timer.setDelay(delay);
            }
            if(scuffedLoad==2) 
            {
                delay=2000;
                timer.setDelay(delay);
            }
            if(test.checkApple()&&HardMode) 
            {
                delay=r.nextInt(75-5)+5;
                timer.setDelay(delay);
                
            }
            for (int i = 0; i < test.getSnakeSize()-2; i++) 
            {
              if(test.checkCollision(i)) running=false;
            }
            if(test.checkWallCollision())running=false;
        }
        if(!running) 
        {
            if(test.getLoadedlvl()!=null) test.SaveLoaded(test.getLoadedlvl());
            else test.Save("Default",true);
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
        
    public class Sound implements Runnable
    {
        Clip clip=null;
        public void stopThread()
        {
            clip.flush();
            clip.stop();
            clip.close();
            this.stopThread();
        }
        @Override
        public void run() {
            
            try {
                String datapath = System.getProperty("user.dir");
            File f = new File(datapath+"/Audio/"+"penis music.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(f);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
            audioIn.close();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
       
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
            if(Thread.interrupted()) try {
                throw new InterruptedException();
            } catch (InterruptedException ex) {
                Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
    
    
}

