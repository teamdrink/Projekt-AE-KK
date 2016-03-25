package pszt;

import java.util.Random;

public class PopulationData
{
	int populationSize = 50;

	Integer[][] popTab;

	private CityData theCityData;

	public PopulationData(CityData theCityData)
	{
		this.theCityData = theCityData;
	}

	public void createPopulation()
	{
		popTab = new Integer[populationSize][theCityData.size];
		for (int i = 0; i < populationSize; ++i)
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
		Integer[] mask = new Integer[x + 1];
		for (int j = 0; j < x + 1; ++j)
		{
			mask[j] = 1;

		}

		int a;

		for (int i = 0; i < x; ++i)
		{
			a = random(x) + 1;
			while(mask[a] == 0)
			{
				a = random(x) + 1;
			}
			mask[a] = 0;
			tab[y][i] = a;
		}
	}

	public void showPopulation()
	{
		for (int i = 0; i < populationSize; ++i)
		{
			for (int j = 0; j < theCityData.size; ++j)
			{
				System.out.print(popTab[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
}
