package pszt;

import java.util.Random;

/**
 * Klasa odpowiedzialna za losowanie odleg�o�ci mi�dzy miastami
 */
public class RandomCity
{

	final int percent =0;

	/**
	 * @param x
	 *            przedzia�
	 * @return zwraca liczb� pseudolosow�
	 */
	public int random(int x)
	{
		Random r = new Random();
		return r.nextInt(x);
	}

	/**
	 * @param tab
	 *            Tablica na odleg�o�ci
	 * @param x
	 *            liczba miast
	 */
	public void randomCity(Integer[][] tab, int x)
	{
		for (int i = 0; i < x; ++i)
		{
			for (int j = i; j < x; ++j)
			{
				tab[i][j] = random(100) + 1 - percent;
				if (tab[i][j] <= 0)
				{
					tab[i][j] = -1;
				}
			}
		}
	}

}
