package pszt;

import java.util.Random;

/**
 * Klasa odpowiedzialna za dane dotycz¹ce populacji
 */
public class PopulationData
{
	final int size;

	Integer[][] popTab, popTabOld, popTabAction;

	int load = 0;

	private CityData theCityData;

	public PopulationData(CityData theCityData, int x)
	{
		this.theCityData = theCityData;
		size = x;
	}

	public void createPopulation()
	{
		System.out.print("Tworzenie populacji ...\n");
		popTabAction = new Integer[size * 2][theCityData.size];
		popTabOld = new Integer[size][theCityData.size];
		popTab = new Integer[size][theCityData.size];
		for (int i = 0; i < size; ++i)
		{

			randomUnit(popTab, theCityData.size, i);
			if ((float) 100 / size * i - load > 1)
			{
				// System.out.print((int)(float)100*i / size);
				for (int k = 0; k < (int) (float) 100 * i / size - load; ++k)
				{
					System.out.print("#");
				}
				++load;

			}
		}
		System.out.print("\n");
	}

	public int random(int x)
	{
		Random r = new Random();
		return r.nextInt(x);
	}

	/**
	 * @param tab
	 *            tablica populacji
	 * @param x
	 *            liczba miast
	 * @param y
	 *            dany osobnik tworzy gen danego osobnika
	 */
	public void randomUnit(Integer[][] tab, int x, int y)
	{
		Exist theExist = new Exist(theCityData);
		Integer[] mask = new Integer[x];

		do
		{
			for (int j = 0; j < x; ++j)
			{
				mask[j] = 1;
			}
			int a;
			for (int i = 0; i < x; ++i)
			{
				a = random(x);
				while (mask[a] == 0)
				{
					a = random(x);
				}
				mask[a] = 0;
				tab[y][i] = a;
			}
		} while (theExist.ifExist(tab, x, y) != true);
		for (int i = 0; i < size; ++i)
		{
			for (int j = 0; j < theCityData.size; ++j)
			{
				popTabOld[i][j] = popTab[i][j];
			}

		}

	}

	public void show()
	{
		for (int i = 0; i < size; ++i)
		{
			for (int j = 0; j < theCityData.size; ++j)
			{
				System.out.print(popTabOld[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}

}
