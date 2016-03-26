package pszt;

import java.util.Random;

public class Crossbreed
{
	private PopulationData thePopulationData;
	private CityData theCityData;

	Integer[] mask;
	Integer[][] popRep, popRepOld;

	public Crossbreed(PopulationData thePopulationData, CityData theCityData)
	{
		this.thePopulationData = thePopulationData;
		this.theCityData = theCityData;
		mask = new Integer[theCityData.size];
		popRep = new Integer[thePopulationData.size][theCityData.size];
		popRepOld = new Integer[thePopulationData.size][theCityData.size];
	}

	public int random(int x)
	{
		Random r = new Random();
		return r.nextInt(x);
	}

	public void Crossbreeding()
	{
		changeRepresentationXY();
		int x;
		for (int i = 0; i < thePopulationData.size / 2; ++i)
		{
			x = random(theCityData.size - 1) + 1;
			for (int j = x; j < theCityData.size; ++j)
			{
				int a, b;
				a = popRepOld[2 * i + 1][j];
				b = popRepOld[2 * i][j];
				popRep[2 * i][j] = a;
				popRep[2 * i + 1][j] = b;
			}
		}
		popRepOld = popRep;
		changeRepresentationYX();

	}

	public void changeRepresentationXY()
	{

		for (int i = 0; i < thePopulationData.size; ++i)
		{
			for (int k = 0; k < theCityData.size; ++k)
			{
				mask[k] = k;
			}
			for (int j = 0; j < theCityData.size; ++j)
			{

				popRep[i][j] = searchXY(thePopulationData.popTabOld[i][j]);
			}
		}
		popRepOld = popRep;
	}

	public int searchXY(int x)
	{
		int X = 0;
		for (int i = 0; i < theCityData.size; ++i)
		{
			if (x == mask[i])
			{
				X = i;
				moving(i);
				i = theCityData.size;
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
				System.out.print(popRepOld[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}

	public void changeRepresentationYX()
	{
		for (int i = 0; i < thePopulationData.size; ++i)
		{
			for (int k = 0; k < theCityData.size; ++k)
			{
				mask[k] = k;
			}
			for (int j = 0; j < theCityData.size; ++j)
			{
				
				thePopulationData.popTab[i][j] = searchYX(popRep[i][j]);
			}
		}
		popRepOld = popRep;
	}

	public int searchYX(int x)
	{
		int X = 0;
		for (int i = 0; i < theCityData.size; ++i)
		{
			if (x == i)
			{
				X = mask[i];
				moving(i);
				i = theCityData.size;
			}
		}
		return X;
	}

}
