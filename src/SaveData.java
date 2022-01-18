
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
double xPos;
double yPos;
int highscore;
double MAP_UNITS;
boolean Hardmode;
String difficulty;
ArrayList<Point2D.Double>Wall=new ArrayList<Point2D.Double>();
ArrayList<Point2D.Double>Snek=new ArrayList<Point2D.Double>();
// level
}

/*/public class ControlSave implements java.io.Serializable
{
private static final long serialVersionUID=1L;

// level
}/*/