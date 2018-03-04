import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

public class WalkingManFrame extends JFrame implements ActionListener
{
	private Man man;
	private ArrayList<Ball> b = new ArrayList<Ball>();
	public WalkingManFrame()
	{
		setBounds(100, 100, 600, 400);
		setLayout(null);
		man = new Man(0, 0);
		add(man);
		setVisible(true);
		Timer timer = new Timer(10, this);
		timer.start();
		addKeyListener(new KeyListener()
				{
					public void keyPressed(KeyEvent e)
					{
						if(e.getKeyCode() == e.VK_W)
						{
							man.setDY(-2);
						}
						if(e.getKeyCode() == e.VK_A)
						{
							man.setDX(-2);
						}
						if(e.getKeyCode() == e.VK_S)
						{
							man.setDY(2);
						}
						if(e.getKeyCode() == e.VK_D)
						{
							man.setDX(2);
						}
						if(e.getKeyCode() == e.VK_SPACE)
						{
							Ball ball = new Ball(man.getX(), man.getY());
							b.add(ball);
							add(ball);
						}
						
					}
					public void keyReleased(KeyEvent e)
					{
						if(e.getKeyCode() == e.VK_W)
						{
							man.setDY(0);
						}
						if(e.getKeyCode() == e.VK_A)
						{
							man.setDX(0);
						}
						if(e.getKeyCode() == e.VK_S)
						{
							man.setDY(0);
						}
						if(e.getKeyCode() == e.VK_D)
						{
							man.setDX(0);
						}
					}
					public void keyTyped(KeyEvent e)
					{
					}
					
				});
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{
		man.update();
		for(int i = 0; i < b.size(); i++)
		{
			b.get(i).update();
			if(b.get(i).getX() > 620)
			{
				this.remove(b.get(i));
				b.remove(i);
			}
		}
		repaint();
	}
	public static void main(String[] args)
	{
		new WalkingManFrame();
		
	}
}