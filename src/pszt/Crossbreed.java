package pszt;

public class Crossbreed
{
	private PopulationData thePopulationData;
	private CityData theCityData;

	Integer[] mask;
	Integer[][] popRep;

	public Crossbreed(PopulationData thePopulationData, CityData theCityData)
	{
		this.thePopulationData = thePopulationData;
		this.theCityData = theCityData;
		mask = new Integer[theCityData.size];
		popRep = new Integer[thePopulationData.size][theCityData.size];
	}

	public void Crossbreeding()
	{
		changeRepresentation();

	}

	public void changeRepresentation()
	{

		for (int i = 0; i < thePopulationData.size; ++i)
		{				
			for (int k = 0; k < theCityData.size; ++k)
				{
					mask[k] = k;
				}
			for (int j = 0; j < theCityData.size; ++j)
			{

				popRep[i][j] = search(thePopulationData.popTab[i][j]);
			}
		}
	}

	public int search(int x)
	{
		int X = 0;
		for (int i = 0; i < theCityData.size; ++i)
		{
			if (x == mask[i])
			{
				X = i;
				moving(i);
				i=theCityData.size;
			}
		}

		return X;

	}

	public void moving(int x)
	{
		for (int i = x; i < theCityData.size - 1; ++i)
		{
			mask[i] = mask[i + 1];
		}
	}

	public void show()
	{
		for (int i = 0; i < thePopulationData.size; ++i)
		{
			for (int j = 0; j < theCityData.size; ++j)
			{
				System.out.print(popRep[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

}
