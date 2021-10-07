/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author Kpaco
 */
public class Snake {
    int snakeSize;
    char dir;
    //probably remade into an array.
    ArrayList<Integer>Snek=new ArrayList<Integer>();
    public Snake()
    {
        Snek.add(0,2);
        for (int i = 1; i < 3; i++)
        {
            Snek.add(i,1);
        }
    }
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
        return Snek.size();
    }
}
