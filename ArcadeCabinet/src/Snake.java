import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class Snake 
	{
	private int coordsX;
	private int coordsY;
	
	public Snake(int cX, int cY)
		{
		coordsX=cX;
		coordsY=cY;
		}


	public int getCoordsX()
		{
			return coordsX;
		}

	public void setCoordsX(int turnCoordsX)
		{
			this.coordsX = turnCoordsX;
		}

	public int getCoordsY()
		{
			return coordsY;
		}

	public void setCoordsY(int turnCoordsY)
		{
			this.coordsY = turnCoordsY;
		}
	
	}
