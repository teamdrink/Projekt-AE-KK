package pszt;

import java.util.Random;

/**
 * Algorytm Krzy¿owania
 */
public class Crossbreed
{
	private PopulationData thePopulationData;
	private CityData theCityData;
	private Exist theExist;

	Integer[] mask;
	Integer[][] popRep, popRepOld;

	public Crossbreed(PopulationData thePopulationData, CityData theCityData, Exist theExist)
	{
		this.thePopulationData = thePopulationData;
		this.theCityData = theCityData;
		this.theExist = theExist;
		mask = new Integer[theCityData.size];
		popRep = new Integer[thePopulationData.size][theCityData.size];
		popRepOld = new Integer[thePopulationData.size][theCityData.size];
	}

	public int random(int x)
	{
		Random r = new Random();
		return r.nextInt(x);
	}

	/**
	 * funkcja krzy¿uj¹ca
	 */
	public void Crossbreeding()
	{
		int load = 0;
		changeRepresentationXY();
		int x;
		for (int i = 0; i < thePopulationData.size / 2; ++i)
		{
			do
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
			} while (changeRepresentationYXOnce(2 * i) != true || changeRepresentationYXOnce(2 * i + 1) != true);
			/*
			 * for(int k=0;k<(int)50/thePopulationData.size;++k){
			 * System.out.print("#"); ++load; }
			 */
			if ((float)32 / thePopulationData.size * i- load > 1)
			{
				//System.out.print((int)(float)32*i / thePopulationData.size);
				for (int k = 0; k < (int)(float)32*i / thePopulationData.size-load; ++k)
				{
					System.out.print("#");
				}
				++load;
			}
			// System.out.print((float)i*2/thePopulationData.size*100+"%\n");
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

	public boolean changeRepresentationYXOnce(int i)
	{
		Integer[][] x = new Integer[1][theCityData.size];
		Integer[][] copy = new Integer[1][theCityData.size];

		for (int k = 0; k < theCityData.size; ++k)
		{
			mask[k] = k;
		}

		for (int j = 0; j < theCityData.size; ++j)
		{
			copy[0][j] = popRep[i][j];
			x[0][j] = searchYX(copy[0][j]);

		}
		// System.out.print(theExist.ifExist(x, theCityData.size, 0)+"
		// "+i+"\n");
		if (theExist.ifExist(x, theCityData.size, 0) == true)
			return true;
		else
			return false;
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
