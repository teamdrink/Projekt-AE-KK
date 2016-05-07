package pszt;

import java.awt.*;
import java.util.Random;

import javax.swing.*;

@SuppressWarnings("serial")
class View extends JPanel
{

	Integer[][] x = new Integer[10][2];
	private PathLength thePathLength;

	public View(PathLength thePathLength)
	{
		this.thePathLength = thePathLength;

	}

	public void paint()
	{
		JFrame frame = new JFrame("KOMIWOJA¯ER");
		JPanel world = new View(thePathLength);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().add(world);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}
	public int random(int x)
	{
		Random r = new Random();
		return r.nextInt(x);
	}

	public void paintComponent(Graphics g)
	{
		int q=random(256);
		int w=random(256);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0 , 1366, 768 );
		for (int i = 0; i < 1366; ++i)
		{
			//if (i % 2 == 0)
			//{
				g.setColor(new Color(q,i*255/1366,w));
			/*} else
			{
				g.setColor(new Color(255,0+i*255/1366,));
			}*/
			int a = thePathLength.x[i][1];
			int b = thePathLength.x[i][0] - thePathLength.x[i][1];
			g.fillRect(i, a/5-thePathLength.x[1365][1]/5+100 , 1, b/5+1 );

		}
	}

}
