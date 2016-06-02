package pszt;

import java.util.Random;

/**
 * Klasa odpowiedzialna za losowanie odleg³oœci miêdzy miastami
 */
public class RandomCity
{

	final int percent = 0;

	/**
	 * @param x
	 *            przedzia³
	 * @return zwraca liczbê pseudolosow¹
	 */
	public int random(int x)
	{
		Random r = new Random();
		return r.nextInt(x);
	}

	/**
	 * @param tab
	 *            Tablica na odleg³oœci
	 * @param x
	 *            liczba miast
	 */
	public void randomCity(int x)
	{
		Integer[][] tab = new Integer[x][x];
		for (int i = 0; i < x; ++i)
		{
			for (int j = i; j < x; ++j)
			{
				tab[i][j] = random(100) + 1 - percent;
				if (tab[i][j] <= 0)
				{
					tab[i][j] = -1;
				}
				if (tab[i][j] == null)
				{
					System.out.print("--" + " ");
				} else
				{
					System.out.print(tab[i][j] + " ");
				}
			}
			System.out.print("\n");
		}
	}

}
