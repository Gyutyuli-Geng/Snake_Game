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
    int SCREEN_WIDTH;
    int SCREEN_HEIGHT;
    int UNIT_SIZE;
    int GAME_UNITS;
    int Map[][];
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
        SCREEN_WIDTH=x;
        SCREEN_HEIGHT=y;
        GAME_UNITS=(SCREEN_WIDTH+SCREEN_HEIGHT);
        Map=new int[GAME_UNITS][GAME_UNITS];
        for (int i = 0; i < GAME_UNITS; i++) {
            for (int j = 0; j < GAME_UNITS; j++) {
                Map[i][j]=0;
            }
        }
    }
    public int[][] Get_Map()
    {
        return Map;
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
               Map[xPos][i]=1;
        }
       /*/ switch(Player.GetSnakeDir())
        {
            case 'u':
                yPos++;       
                Map[xPos][yPos-1]=0;
                Map[xPos][yPos]=1;
            case 'd':
                yPos--;
                Map[xPos][yPos+1]=0;
                Map[xPos][yPos]=1;
            case 'r':
                xPos++;
                Map[xPos][yPos]=1;
            case 'l':
                xPos--;
                Map[xPos][yPos]=1;
                
        }/*/
    }
    public void GenApple()
    {
        Random ran=new Random();
        int ran_X=ran.nextInt(GAME_UNITS);
        int ran_Y=ran.nextInt(GAME_UNITS);
        Map[ran_X][ran_Y]=1;
    }
}
