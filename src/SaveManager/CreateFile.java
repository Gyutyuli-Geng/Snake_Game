package SaveManager;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kpaco
 */
public class CreateFile {
    FileWriter myWriter;
    public void CreateTxt(String FileName)
    {
        try {
      File myObj = new File(FileName);
      if (myObj.createNewFile()) {
      } else {
      }
    } catch (IOException e) {
      
      e.printStackTrace();
    }
    }
    public void openWrite(String FileName)
    {
        try
        {
       myWriter = new FileWriter(FileName); 
        }
        catch (IOException e) {
     
      e.printStackTrace();
    }
    }
    public void Write(ArrayList<String> data)
    {
        try {
      
      for (int i = 0; i < data.size(); i++) 
      {
           myWriter.write(data.get(i));    
      }
      myWriter.write("\r\n");
    } catch (IOException e) {
   
      e.printStackTrace();
    }
    }
    public void closeWrite()
    {
        try{
        myWriter.close();}
        catch (IOException e) {
     // System.out.println("An error occurred.");
      e.printStackTrace();
    }
    }
}
