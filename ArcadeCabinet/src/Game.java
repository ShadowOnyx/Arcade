import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class Game extends JPanel 
	{
	int x=225;
	int y=200;
	static boolean right=false;
	static boolean left=false;
	static boolean up=false;
	static boolean down=false;
	static boolean pigsFly;
	static int xFoodCoord;
	static int yFoodCoord;
	ArrayList <Snake> snake = new ArrayList <Snake>();
	public Game() 
		{
		KeyListener listener = new KeyListener() 
			{
			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) 
				{
				System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
				if(KeyEvent.getKeyText(e.getKeyCode()).equals("Left")&&right==false)
					{
					up=false;
					down=false;
					left=true;	
					}
				if(KeyEvent.getKeyText(e.getKeyCode()).equals("Right")&&left==false)
					{
					up=false;
					down=false;
					right=true;	
					}
				if(KeyEvent.getKeyText(e.getKeyCode()).equals("Up")&&down==false)
					{
					up=true;
					right=false;
					left=false;	
					}
				if(KeyEvent.getKeyText(e.getKeyCode()).equals("Down")&&up==false)
					{
					right=false;
					down=true;
					left=false;	
					}
				}

			@Override
			public void keyReleased(KeyEvent e) {
					
			}
		};
		addKeyListener(listener);
		setFocusable(true);
	}
	
	
	@Override
	public void paint(Graphics g) 
		{	
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.orange);
		g2d.fillOval(xFoodCoord, yFoodCoord, 25, 25);
		g2d.setColor(Color.black);
		g2d.fillRect(x, y, 25, 25 );	
		}
	public static void main(String[] args) 
		{
		boolean food=false;
		JFrame frame = new JFrame("FALLOUT 5 PUBLIC ALPHA BUILD -0.01");
		Game game = new Game();
		frame.add(game);
		frame.setSize(480,475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		game.greet();
		while(!pigsFly)
			{
			System.out.println("FOOD x "+game.xFoodCoord);
			System.out.println("FOOD y "+game.yFoodCoord);
			System.out.println("x "+game.x);
			System.out.println("y "+game.y);
			food = game.createFood(food);
			game.movement();
			game.movementBabySnake();
			food = game.checkForEat(food);
			game.repaint();
			
			try
				{
				Thread.sleep(180);
				} catch (InterruptedException e)
				{
				e.printStackTrace();
				}
			}
		}
	public boolean createFood(boolean food)
		{
		if(!food)
			{
			int lastCoordX=xFoodCoord;	
			int lastCoordY=yFoodCoord;
			xFoodCoord = (int)(Math.random()*19)*25;
			yFoodCoord = (int)(Math.random()*18)*25;
			if(lastCoordX==xFoodCoord&&lastCoordY==yFoodCoord)
				createFood(food);
			}
		return food=true;
		}
	public void gameOver() 
		{
		JOptionPane.showMessageDialog(this, ":(", "Game Over!", JOptionPane.YES_NO_OPTION);
		System.exit(0);
		}
	public boolean checkForEat(boolean food)
		{
		if(food&&xFoodCoord==x&&yFoodCoord==y)
			{
	
			return food=false;	
			}
		return food;
		}
	public void greet()	
		{
		JOptionPane.showMessageDialog(this, "Thank you for alpha testing, remember that the contents of this tech demo are not representative of the final product.", "", JOptionPane.YES_NO_OPTION);	
		}
	public void movement()
		{
		if (x  < 0)
			{
			System.out.println("YOU LOSE :^ )");
			left=false;
			gameOver();
			}
		if (x  >= 500-49)
			{
			System.out.println("YOU LOSE :^ )");
			right=false;
			gameOver();
			}
		else if (y  < 0)
			{
			System.out.println("YOU LOSE :^ )");	 
			up=false;
			gameOver();
			}
		else if (y  >= 500-51)
			{
			System.out.println("YOU LOSE :^ )");	
			down=false;
			gameOver();
			}
		if(right)
			x= x+25;
		else if(left)
			x=x-25;
		else if(up)
			y=y-25;
		else if(down)
			y=y+25;
		
		}
	public void movementBabySnake()
		{
		
		if(right)
			x= x+25;
		else if(left)
			x=x-25;
		else if(up)
			y=y-25;
		else if(down)
			y=y+25;
		
		}

	}