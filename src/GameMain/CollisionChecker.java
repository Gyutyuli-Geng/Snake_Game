package GameMain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kpaco
 */
public class CollisionChecker{
    public boolean checkWallCollision(Walls Wall,double locX,double locY,double UNIT_SIZE) 
    {
        int start=0;
        int end=0;
        for (int i = 0; i < Wall.Wall.size(); i=i+2) 
        {
            if(locX==Wall.getArrayPoint(i).getX()*(int)UNIT_SIZE )
            {
                start=(int)Wall.getArrayPoint(i).getY()*(int)UNIT_SIZE;
                end=(int)Wall.getArrayPoint(i+1).getY()*(int)UNIT_SIZE;   
                if(start<=locY&&locY<=end || start>=locY&&locY>=end) return true;
            }
            else if(locY==Wall.getArrayPoint(i).getY()*(int)UNIT_SIZE)
            {
                start=(int)Wall.getArrayPoint(i).getX()*(int)UNIT_SIZE;
                end=(int)Wall.getArrayPoint(i+1).getX()*(int)UNIT_SIZE;
                if(start<=locX&&locX<=end || start>=locX&&locX>=end) return true;
            }
        }
        return false;
    }
    public int checkWallCollision(Walls Wall,double locX,double locY,double UNIT_SIZE,int asdf) 
    {
        int start=0;
        int end=0;
        for (int i = 0; i < Wall.Wall.size(); i=i+2) 
        {
            if(locX==Wall.getArrayPoint(i).getX()*(int)UNIT_SIZE )
            {
                start=(int)Wall.getArrayPoint(i).getY()*(int)UNIT_SIZE;
                end=(int)Wall.getArrayPoint(i+1).getY()*(int)UNIT_SIZE;   
                if(start<=locY&&locY<=end || start>=locY&&locY>=end) return Wall.Wall.indexOf(Wall.getArrayPoint(i));
            }
            else if(locY==Wall.getArrayPoint(i).getY()*(int)UNIT_SIZE)
            {
                start=(int)Wall.getArrayPoint(i).getX()*(int)UNIT_SIZE;
                end=(int)Wall.getArrayPoint(i+1).getX()*(int)UNIT_SIZE;
                if(start<=locX&&locX<=end || start>=locX&&locX>=end) return Wall.Wall.indexOf(Wall.getArrayPoint(i));
            }
        }
        return -1;
    }
}
