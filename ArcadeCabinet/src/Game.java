import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel 
	{
	int x=0;
	int y=0;
	boolean inGame=true;

	
	
	@Override
	public void paint(Graphics g) 
		{	
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.black);
		g2d.fillRect(x, y, 25, 25);	
		
		}
	
	
	public static void main(String[] args) 
		{
		JFrame frame = new JFrame("SNAEK");
		Game game = new Game();
		frame.add(game);
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		while(true)
			{
			Snake.movement();
			game.repaint();
			try
				{
				Thread.sleep(1000);
				} catch (InterruptedException e)
				{
				e.printStackTrace();
				}
			}
		}

	}