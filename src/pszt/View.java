/*package pszt;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
class View extends JPanel
{
	private PathLength thePathLength;
	
	public View(PathLength thePathLength)
	{
		this.thePathLength = thePathLength;

	}

	public void paintComponent(Graphics g)
	{
		int a=thePathLength.max();
		int b=thePathLength.min();
		g.setColor(Color.black);
		g.fillRect(10, b, 5, a-b);
	}

	public void paint()
	{

		JFrame frame = new JFrame("KOMIWOJA¯ER");
		JPanel world = new View(thePathLength);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().add(world);
		frame.pack();
		frame.setVisible(true);
	}
	


}*/