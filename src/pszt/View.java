package pszt;

import java.awt.*;
import javax.swing.*;

/**
 * Widok
 */
public class View
{

	public View()
	{

		Canvas canvas = new Canvas();
		JFrame window = new JFrame("Komiwoja¿er");
		JPanel panel = (JPanel) window.getContentPane();

		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		panel.add(canvas);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}


}