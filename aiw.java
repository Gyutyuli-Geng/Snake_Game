/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
       Cycle=new int[ColumNum*RowNum];
       Grid=new int[ColumNum][RowNum];
       for (int i = 0; i < ColumNum; i++)
       {
            for (int j = 0; j < RowNum; j++)
            {
                if (i%2 == 1)
                {   
                    Grid[i][j] = (i)*(ColumNum-1)+j;
                    
                }
                if (i%2 == 0)
                {
                    Grid[i][j] = i*(ColumNum-1)-(j);
                }
            }     
       }
       for (int i = 0; i < RowNum; i++)
       {
           Grid[0][i] = ColumNum*RowNum-(i);
       }
       for (int i = 0; i < ColumNum; i++)
       {
            for (int j = 0; j < RowNum; j++)
            {
                Cycle[Grid[i][j]-1]=(i-1)*10+(j-1);
            }
       }
    }
    public char butaai(int headx, int heady) //1=föl 2=jobbra 3=le 4=ballra
    {
       int temp=0;
       temp = Cycle[Grid[headx][heady]];
       temp = Cycle[Grid[headx][heady]+1] - temp;
       if (temp == 1)
       {
           return 'R';
       }
       if (temp == -1)
       {
           return 'L';
       }    
       if (temp == 10)
       {
           return 'U';
       }
       else
       {
           return 'D';
       }
    }
}