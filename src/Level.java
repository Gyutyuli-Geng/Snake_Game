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
    int Screen_Width;
    int Screen_Height;
    int UNIT_SIZE=25;
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
        Screen_Width=x;
        Screen_Height=y;
        GAME_UNITS=(Screen_Width*Screen_Height/UNIT_SIZE);
        X=new int[GAME_UNITS];
        Y=new int[GAME_UNITS];
    }
    public int Get_Gameunits()
    {
        return UNIT_SIZE;
    }
    public int[] Get_MapX()
    {
        return X;
    }
    public int[] Get_MapY()
    {
        return Y;
    }
    public int Get_ScreenHeight()
    {
        return  Screen_Height;
    }
    public int Get_ScreenWidth()
    {
        return  Screen_Width;
    }
    public int Get_MapSize()
    {
        return GAME_UNITS;
    }
    public void Generate_Map()
    {
        //put map from txt here if chosen.
    }
    public int Calc_QuarterScreen()
    {
        return (Screen_Width/4)/UNIT_SIZE;
    }
    public int Calc_RightQuarter()
    {
        return ((Screen_Width/4)*3)/UNIT_SIZE;
    }
    public void Move()
    {
        for (int i = Player.getSnakeSize(); i > 0; i--) {
               X[i]=X[i-1];
               Y[i]=Y[i-1];
        }
    }
    public int Get_appleX()
    {
        return appleX;
    }
    public int Get_appleY()
    {
        return appleY;
    }
    public void GenApple()
    {
        Random ran=new Random();
        appleX=ran.nextInt((int)(Calc_RightQuarter())-Calc_QuarterScreen())+Calc_QuarterScreen();
        appleX=appleX*UNIT_SIZE;
        appleY=ran.nextInt((int)(Screen_Height/UNIT_SIZE))*UNIT_SIZE;
    }
}
