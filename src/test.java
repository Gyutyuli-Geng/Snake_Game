/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
/**
 *
 * @author Kpaco
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
        FileWriter writer = new FileWriter("H:/demo.txt");
        
        Level test=new Level(5,5);
        
        for (int i = 0; i < 4; i++) {
            int gay[][]=test.Get_Map();
            //test.Move();
            test.GenApple();
            writer.write('s');
            System.out.println(Arrays.deepToString(gay));
            }  
        writer.close();
        }
       catch(IOException e){}
        }
       
    }
    

