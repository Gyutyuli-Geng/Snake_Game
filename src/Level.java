/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.util.Random;

/**
 *
 * @author Kpaco
 */
public class Level extends JPanel {
    int Map_Xsize;
    int Map_Ysize;
    int UNIT_SIZE;
    int GAME_UNITS;
    int X[];
    int Y[];
    int SnakeSize=3;
    int appleX;
    int appleY;
    char direction ='R';
    int obstacleX;
    int obstacleY;
    int xPos=0;
    int yPos=0;
    Snake Player=new Snake();
    public Level(int x, int y)
    {
        Map_Xsize=x;
        Map_Ysize=y;
        GAME_UNITS=(Map_Xsize*Map_Ysize);
        X=new int[Map_Xsize];
        Y=new int[Map_Ysize];
       
    }
    public int Get_Gameunits()
    {
        return GAME_UNITS;
    }
    public int[] Get_MapX()
    {
        return X;
    }
    public int[] Get_MapY()
    {
        return Y;
    }
    public int Get_MapXsize()
    {
        return Map_Xsize;
    }
    public int Get_MapYsize()
    {
        return Map_Ysize;
    }
    public int Get_MapSize()
    {
        return GAME_UNITS;
    }
    public void Generate_Map()
    {
        //put map from txt here if chosen.
    }
    public void Move()
    {
        for (int i = Player.getSnakeSize(); i > 0; i--) {
               X[i]=X[i-1];
               Y[i]=Y[i-1];
        }
    }
    public void GenApple()
    {
        Random ran=new Random();
        appleX=ran.nextInt(GAME_UNITS);
        appleY=ran.nextInt(GAME_UNITS);
    }
}
