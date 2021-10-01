/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kpaco
 */
public class Snake {
    int snakeSize;
    char dir;
    //probably remade into an array.
    public void setSnakeSize(int a)
    {
        snakeSize=a;
    }
    public void SetSnakeDir(char d)
    {
        dir=d;
    }
    public char GetSnakeDir()
    {
        return dir;
    }
    public int getSnakeSize()
    {
        return snakeSize;
    }
}
