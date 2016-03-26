/*package pszt;

import java.awt.*;
import javax.swing.*;


class View extends JPanel
{	
	
	Integer[][] x= new Integer[10][2];
	private PathLength thePathLength;
	
	public View(PathLength thePathLength)
	{
		this.thePathLength = thePathLength;

	}
	public void paint(Integer[][] a)
	{
		for(int i=0;i<10;++i){
			x[i][0]=a[i][0];
			x[i][1]=a[i][1];			
		}	System.out.print(x[1][1]);
		JFrame frame = new JFrame("KOMIWOJA¯ER");
		JPanel world = new View(thePathLength);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().add(world);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public void paintComponent(Graphics g)
	{
			g.setColor(Color.black);	
		
		for(int i=0;i<10;++i){	
		g.fillRect(100, 100, 5,100+i);			
		}

	}





	


}*/