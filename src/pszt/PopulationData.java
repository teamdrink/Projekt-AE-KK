package pszt;

import java.util.Random;

public class PopulationData
{
	final int size =500;

	Integer[][] popTab, popTabOld, popTabAction;

	private CityData theCityData;

	public PopulationData(CityData theCityData)
	{
		this.theCityData = theCityData;
	}

	public void createPopulation()
	{
		popTabAction = new Integer[size * 2][theCityData.size];
		popTabOld = new Integer[size][theCityData.size];
		popTab = new Integer[size][theCityData.size];
		for (int i = 0; i < size; ++i)
		{
			randomUnit(popTab, theCityData.size, i);
		}

	}

	public int random(int x)
	{
		Random r = new Random();
		return r.nextInt(x);
	}

	public void randomUnit(Integer[][] tab, int x, int y)
	{
		Integer[] mask = new Integer[x];
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
