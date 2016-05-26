package pszt;

import java.util.Arrays;
import java.util.Random;

/**
 * Algorytm Krzy¿owania
 */
public class Crossbreed
{
int procent= 25;
int limit;
	
	
	private PopulationData thePopulationData;
	private CityData theCityData;

	Integer[] mask;
	Integer[][] popRep, popRepOld;

	/**
	 * @param thePopulationData
	 * @param theCityData
	 *            konstruktor
	 */
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

	/**
	 * funkcja krzy¿uj¹ca
	 */
	public void Crossbreeding()
	{		
		
		int load = 0;
		calculatePath();
		changeRepresentationXY();
		int x = 0, A = 0, B = 0;
		int a = 0, b = 0;
		
		for (int i = 0; i < thePopulationData.size / 2; ++i)
		{
			do
			{
				do
				{
					do{
					A = random(thePopulationData.size);
					}while(limit<pathLenght[A]);
					do{
					B = random(thePopulationData.size);
					}while(limit<pathLenght[B]);
			
				} while (A == B);
				x = random(theCityData.size - 1) + 1;
				for (int j = 0; j < theCityData.size; ++j)
				{
					a = popRepOld[A][j];
					b = popRepOld[B][j];
					if (j < x)
					{
						popRep[i * 2][j] = popRepOld[B][j];
						popRep[i * 2 + 1][j] = popRepOld[A][j];
					} else
					{
						popRep[i * 2][j] = a;
						popRep[i * 2 + 1][j] = b;
					}
				}
			} while (changeRepresentationYXOnce(i * 2) == false || changeRepresentationYXOnce(i * 2 + 1) == false);

			if ((float) 32 / thePopulationData.size * i - load > 1)
			{
				for (int k = 0; k < (int) (float) 32 * i / thePopulationData.size - load; ++k)
				{
					System.out.print("#");
				}
				++load;
			}
		}
		popRepOld = popRep;
		changeRepresentationYX();
	}
	
	Integer[] pathLenght ;
	
	public void calculatePath()
	{
		pathLenght = new Integer[thePopulationData.size];
		for (int i = 0; i < thePopulationData.size; ++i)
		{
			pathLenght[i]=0;
			for (int j = 0; j < theCityData.size - 1; ++j)
			{
				if (thePopulationData.popTabOld[i][j] < thePopulationData.popTabOld[i][j + 1])
				{
					pathLenght[i] += theCityData.cityTab[thePopulationData.popTabOld[i][j]][thePopulationData.popTabOld[i][j+ 1]];
				} else
				{
					pathLenght[i] += theCityData.cityTab[thePopulationData.popTabOld[i][j+ 1]][thePopulationData.popTabOld[i][j]];
				}
			}
		}
		Integer[]pathLenght2 = pathLenght;
		Arrays.sort(pathLenght2);
		limit=pathLenght2[(int)(thePopulationData.size*procent/100)];
	}

	/**
	 * Zamiana reprezentacji na reprezentacji "ci¹g³¹"
	 */
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

	/**
	 * @param x
	 *            dane miasto
	 * @return zwracamy jego zmienion¹ reprezentacje
	 */
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

	/**
	 * @param x
	 *            liczba okreœlaj¹ca od którego elementu maski mamy j¹ przesówaæ
	 */
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
		Exist theExist = new Exist(theCityData);
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