/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kpaco
 */

import java.io.File;
import java.io.IOException;
public class LevelEditor{
    public LevelEditor()
    {
    }
    public void SaveLevel(String name)
    {
        try{
        File obj=new File(name);
        if(obj.createNewFile())
        {
            //show message stating file was created
        }
        else
        {
            //file exists
            //do rest
        }
        }
        catch(IOException e)
        {
        
        }
        
        
    }
}
    

