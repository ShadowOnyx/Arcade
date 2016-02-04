import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class MainMenu
	{

		public static void main(String[] args)
			{
			JFrame frame = new JFrame("SNAEKE");
			frame.setSize(600,600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
			}
		public void paint(Graphics graphics)
			{
			graphics.setColor(Color.black);
			graphics.drawRect(40, 30,300,400);
			}

	}
