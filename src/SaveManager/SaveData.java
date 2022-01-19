package SaveManager;


import java.awt.Component;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kpaco
 */
public class SaveData implements java.io.Serializable
{
private static final long serialVersionUID=1L;
public double xPos;
public double yPos;
public int highscore;
public double MAP_UNITS;
public boolean Hardmode;
public String difficulty;
public ArrayList<Point2D.Double>Wall=new ArrayList<Point2D.Double>();
public ArrayList<Point2D.Double>Snek=new ArrayList<Point2D.Double>();
// level
}

/*/public class ControlSave implements java.io.Serializable
{
private static final long serialVersionUID=1L;

// level
}/*/