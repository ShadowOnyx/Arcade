import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class Snake 
	{
	private static int length;
	private static int turnCoordsX;
	private static int turnCoordsY;
	
	public Snake(int l, int cX, int cY)
		{
		length=l;
		turnCoordsX=cX;
		turnCoordsY=cY;
		}

	public static int getLength()
		{
			return length;
		}

	public static void setLength(int length)
		{
			Snake.length = length;
		}

	public static int getTurnCoordsX()
		{
			return turnCoordsX;
		}

	public static void setTurnCoordsX(int turnCoordsX)
		{
			Snake.turnCoordsX = turnCoordsX;
		}

	public static int getTurnCoordsY()
		{
			return turnCoordsY;
		}

	public static void setTurnCoordsY(int turnCoordsY)
		{
			Snake.turnCoordsY = turnCoordsY;
		}
	
	}
