
import java.awt.Graphics2D;

public class Snake {
	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
	private Game game;

	public Snake(Game game) {
		this.game= game;
	}

	void movement()
		{
		if (x  < 0)
			System.out.println("YOU LOSE :^ )");	 
		if (x  > game.getWidth()-25)
			System.out.println("YOU LOSE :^ )");	
		if (y  < 0)
			System.out.println("YOU LOSE :^ )");	 
		if (y  > game.getHeight()-25)
			System.out.println("YOU LOSE :^ )");	
		x=x+25;
		y=y+25;
		}

	public void paint(Graphics2D g) {
		g.fillOval(x, y, 30, 30);
	}
}