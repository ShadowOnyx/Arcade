import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class Game extends JPanel 
	{
	int x=0;
	int y=0;
	static boolean inGame=true;
	static boolean right=true;
	static boolean left=false;
	static boolean up=false;
	static boolean down=false;
	
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
					left=true;	
					}
				if(KeyEvent.getKeyText(e.getKeyCode()).equals("Down")&&up==false)
					{
					right=false;
					down=true;
					left=true;	
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
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.black);
		g2d.fillRect(x, y, 25, 25 );	
		
		}
	
	
	public static void main(String[] args) 
		{
		JFrame frame = new JFrame("SNAEK");
		Game game = new Game();
		frame.add(game);
		frame.setSize(480,480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		while(inGame)
			{
			System.out.println("x "+game.x);
			System.out.println("y "+game.y);
			game.movement();
			game.repaint();
			
			try
				{
				Thread.sleep(100);
				} catch (InterruptedException e)
				{
				e.printStackTrace();
				}
			}
		}
	

	public void movement()
		{
		if (x  < 0)
			{
			System.out.println("YOU LOSE :^ )");
			left=false;
			}
		if (x  >= 500-49)
			{
			System.out.println("YOU LOSE :^ )");
			right=false;
			}
		else if (y  < 0)
			{
			System.out.println("YOU LOSE :^ )");	 
			up=false;
			}
		else if (y  >= 500-49)
			{
			System.out.println("YOU LOSE :^ )");	
			down=false;
			}
		if(right)
			x= x+25;
		if(left)
			x=x-25;
		if(up)
			y=y-25;
		if(down)
			y=y+25;
		
		}

	}