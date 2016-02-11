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
		for(int i=0;i<snake.size();i++)
			{
			
			g2d.fillRect(snake.get(i).getCoordsX(), snake.get(i).getCoordsY(), 25, 25 );	
			}
		}
	
	public static void main(String[] args) 
		{
		Game game = new Game();
		game.snake.add(new Snake(225,200));
		game.snake.add(new Snake(200,200));
		game.snake.add(new Snake(175,200));
		boolean food=false;
		JFrame frame = new JFrame("FALLOUT 5 PUBLIC ALPHA BUILD -0.01");		
		frame.add(game);
		frame.setSize(480,478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		game.greet();
		int counter=0;
		while(!pigsFly)
			{
			System.out.println("FOOD x "+game.xFoodCoord);
			System.out.println("FOOD y "+game.yFoodCoord);
			System.out.println("x "+game.snake.get(0).getCoordsX());
			System.out.println("y "+game.snake.get(0).getCoordsY());
			food = game.createFood(food);
			game.movement();
			
			counter = game.checkCannabalism(counter);
			game.movementBabySnake();
			food = game.checkForEat(food);
			game.repaint();
			
			try
				{
				Thread.sleep(120);
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
		if(food&&xFoodCoord==snake.get(0).getCoordsX()&&yFoodCoord==snake.get(0).getCoordsY())
			{
			
			snake.add(new Snake(500,500));
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
		if (snake.get(0).getCoordsX()  < 0)
			{
			left=false;
			gameOver();
			}
		else if (snake.get(0).getCoordsX()  >= 475)
			{
			right=false;
			gameOver();
			}
		else if (snake.get(0).getCoordsY()  < 0)
			{
			up=false;
			gameOver();
			}
		else if (snake.get(0).getCoordsY()  >= 450)
			{
			down=false;
			gameOver();
			}
		if(right)
			snake.get(0).setCoordsX(snake.get(0).getCoordsX()+25);
		else if(left)
			snake.get(0).setCoordsX(snake.get(0).getCoordsX()-25);
		else if(up)
			snake.get(0).setCoordsY(snake.get(0).getCoordsY()-25);
		else if(down)
			snake.get(0).setCoordsY(snake.get(0).getCoordsY()+25);
		
		}
	public void movementBabySnake()
		{
			
		for(int i=snake.size();i>1;i--)
			{
			snake.get(i-1).setCoordsX(snake.get(i-2).getCoordsX());
			snake.get(i-1).setCoordsY(snake.get(i-2).getCoordsY());
			}
		}
	public int checkCannabalism(int c)
		{
		c++;
		System.out.println(c);
		if(c>3)
			{
			for(Snake i:snake)
			{
			if(snake.get(0).getCoordsX()==i.getCoordsX())
				{
				if(snake.get(0).getCoordsY()==i.getCoordsY())
					gameOver();
				}
			}
		}
	return c;
	}
}