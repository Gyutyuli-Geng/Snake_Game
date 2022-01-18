/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.Point;
import javax.swing.*;
import java.util.Random;

/**
 *
 * @author Kpaco
 */
public class LevelTest {
    
    public LevelTest() {
    }

    /**
     * Test of ConstructLvL method, of class Level.
     */
    @Test
    public void testConstructLvL() {
        
    }

    /**
     * Test of GetWallPoint method, of class Level.
     */
    @Test
    public void testGetWallPoint() {
    }

    /**
     * Test of getWallDistnaceY method, of class Level.
     */
    @Test
    public void testGetWallDistnaceY() {
    }

    /**
     * Test of getWallDistnaceX method, of class Level.
     */
    @Test
    public void testGetWallDistnaceX() {
    }

    /**
     * Test of Get_Gameunits method, of class Level.
     */
    @Test
    public void testGet_Gameunits() {
    }

    /**
     * Test of Get_ScreenHeight method, of class Level.
     */
    @Test
    public void testGet_ScreenHeight() {
    }

    /**
     * Test of Get_ScreenWidth method, of class Level.
     */
    @Test
    public void testGet_ScreenWidth() {
    }

    /**
     * Test of Get_MapSize method, of class Level.
     */
    @Test
    public void testGet_MapSize() {
    }

    /**
     * Test of Generate_Map method, of class Level.
     */
    @Test
    public void testGenerate_Map() {
    }

    /**
     * Test of Calc_QuarterScreen method, of class Level.
     */
    @Test
    public void testCalc_QuarterScreen() {
        Level level=new Level();
        level.ConstructLvL(0,0,null);
        assertNotNull(level.Calc_QuarterScreen());
    }

    /**
     * Test of Calc_RightQuarter method, of class Level.
     */
    @Test
    public void testCalc_RightQuarter() {
        Level level=new Level();
        level.ConstructLvL(0,0,null);
        assertNotNull(level.Calc_RightQuarter());
        
    }

    /**
     * Test of Move method, of class Level.
     */
    @Test
    public void testMove() {
        Level level=new Level();
        level.ConstructLvL(0,0,null);
        assertNotNull(level.GetSnakeDir());
        assertNotNull(level.Player.Snek);
    }

    /**
     * Test of checkCollision method, of class Level.
     */
    @Test
    public void testCheckCollision() {
        Level level=new Level();
        level.ConstructLvL(0, 0,null);
        if(level.Player.getHead().equals(level.Player.getArrayPoint(2)))
        {
            assertSame("snek collides with itself",level.Player.getHead(),level.Player.getArrayPoint(2));
        }
        else assertNotSame("snek doesnt collide with itself",level.Player.getHead(),level.Player.getArrayPoint(2));
    }

    /**
     * Test of checkWallCollision method, of class Level.
     */
    @Test
    public void testCheckWallCollision() {
        Level level=new Level();
        level.ConstructLvL(0,0,null);
        assertNotNull(level.Player.getHead());
        assertNotNull(level.Wall.Wall);
    }

    /**
     * Test of checkAppleGenCoords method, of class Level.
     */
    @Test
    public void testCheckAppleGenCoords() {
        Level level=new Level();
        level.ConstructLvL(0,0,null);
        assertNotNull(level.apple);
        assertNotNull(level.Wall.Wall);
    }

    /**
     * Test of getSnakeHeadX method, of class Level.
     */
    @Test
    public void testGetSnakeHeadX() {
    }

    /**
     * Test of getBodyX method, of class Level.
     */
    @Test
    public void testGetBodyX() {
    }

    /**
     * Test of getBodyY method, of class Level.
     */
    @Test
    public void testGetBodyY() {
    }

    /**
     * Test of getSnakeHeadY method, of class Level.
     */
    @Test
    public void testGetSnakeHeadY() {
    }

    /**
     * Test of getSnakeSize method, of class Level.
     */
    @Test
    public void testGetSnakeSize() {
    }

    /**
     * Test of SetSnakeDir method, of class Level.
     */
    @Test
    public void testSetSnakeDir() {
    }

    /**
     * Test of GetSnakeDir method, of class Level.
     */
    @Test
    public void testGetSnakeDir() {
    }

    /**
     * Test of checkApple method, of class Level.
     */
    @Test
    public void testCheckApple() {
         Level level=new Level();
         level.ConstructLvL(1920, 1080,null);
         level.GenApple();
        if(level.apple.equals(level.Player.getHead())) 
        {
            level.Player.growSnake();
            do
            {
                level.GenApple();
            }
            while(level.checkAppleGenCoords());
        }
    }

    /**
     * Test of Get_appleX method, of class Level.
     */
    @Test
    public void testGet_appleX() {
    }

    /**
     * Test of Get_appleY method, of class Level.
     */
    @Test
    public void testGet_appleY() {
    }

    /**
     * Test of GenApple method, of class Level.
     */
    @Test
    public void testGenApple() {
        
        Level level=new Level();
        level.ConstructLvL(1920, 1080,null);
        Point apple=new Point();
        Random ran=new Random();
       
        level.appleX=ran.nextInt((int)level.Calc_RightQuarter()-(int)level.Calc_QuarterScreen())+level.Calc_QuarterScreen();
        level.appleY=(ran.nextInt((int)(level.Screen_Height/level.UNIT_SIZE)-0)+0);
        apple.setLocation(Math.floor(level.appleX*level.UNIT_SIZE),Math.floor(level.appleY*level.UNIT_SIZE));
        assertNotNull(level.appleX);
        assertNotNull(level.appleY);
        assertNotNull("ye apple got generated",level.apple);
    }
    
}
