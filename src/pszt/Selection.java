package pszt;

import java.util.Arrays;

public class Selection
{
	private PopulationData thePopulationData;
	private CityData theCityData;
	private PathLength thePathLength;

	public Selection(PopulationData thePopulationData, CityData theCityData, PathLength thePathLength)
	{
		this.thePopulationData = thePopulationData;
		this.theCityData = theCityData;
		this.thePathLength = thePathLength;
	}

	public void addPopulation()
	{
		for (int i = 0; i < thePopulationData.size; ++i)
		{
			for (int j = 0; j < theCityData.size; ++j)
			{

				thePopulationData.popTabAction[i][j] = thePopulationData.popTabOld[i][j];
			}
		}
		for (int i = thePopulationData.size; i < thePopulationData.size * 2; ++i)
		{
			for (int j = 0; j < theCityData.size; ++j)
			{

				thePopulationData.popTabAction[i][j] = thePopulationData.popTab[i - thePopulationData.size][j];
			}
		}
	}

	public void show()
	{
		for (int i = 0; i < thePopulationData.size * 2; ++i)
		{
			for (int j = 0; j < theCityData.size; ++j)
			{
				System.out.print(thePopulationData.popTabAction[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}

	public void selecting()
	{
		int x = 0,a=0;
		thePathLength.calculatePathSelection();
		Integer[] tab = new Integer[thePopulationData.size * 2];
		for (int j = 0; j < thePopulationData.size * 2; ++j)
		{
			tab[j] = thePathLength.pathLenghtAction[j];
		}
		Arrays.sort(tab);
		for (int j = 0; j < thePopulationData.size * 2; ++j)
		{
			System.out.print(" /" + tab[j] + "/  ");
		}
		
		for (int i = 0; i < thePopulationData.size*2; ++i)
		{
			if (thePathLength.pathLenghtAction[i] < tab[thePopulationData.size])
			{
				for (int k = 0; k < theCityData.size; ++k)
				{System.out.print(a);
					thePopulationData.popTabOld[a][k] = thePopulationData.popTabAction[i][k];
					++a;
				}
			}

		}
	}

}
