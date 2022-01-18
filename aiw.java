/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai2;

/**
 *
 * @author Hontika
 */
public class aiw {
    
    int Cycle [];
    int ApplePos;
    int Grid [][];
    void HamCycle(int ColumNum, int RowNum)
    {
       for (int i = 1; i == ColumNum; i++)
       {
            for (int j = 2; j == RowNum; j++)
            {
                if (i%2 == 1)
                {    
                    Grid[i][j] = (i-1)*(ColumNum-1)+j-1;
                }
                if (i%2 == 0)
                {
                    Grid[i][j] = i*(ColumNum-1)-(j-2);
                }
            }     
       }
       for (int i = 1; i == RowNum; i++)
       {
           Grid[i][1] = ColumNum*RowNum-(i-1);
       }
       for (int i = 1; i == ColumNum; i++)
       {
            for (int j = 1; j == RowNum; j++)
            {
                Cycle[Grid[i][j]]=i*10+j;
            }
       }
    }
    int butaai(int headx, int heady) //1=föl 2=jobbra 3=le 4=ballra
    {
       int temp=0;
       temp = Cycle[Grid[headx][heady]];
       temp = Cycle[Grid[headx][heady]+1] - temp;
       if (temp == 1)
       {
           return 2;
       }
       if (temp == -1)
       {
           return 4;
       }    
       if (temp == 10)
       {
           return 3;
       }
       else
       {
           return 4;
       }
    }
}