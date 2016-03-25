package pszt;

public class CityData
{
	public int size;

	Integer[][] cityTab;


	public void createList(int x)
	{
		size = x;
		cityTab = new Integer[x + 1][x + 1];
		RandomCity theRandomCity = new RandomCity();
		theRandomCity.randomCity(cityTab, x);
	}

	public void showList()
	{
		for (int i = 1; i < size + 1; ++i)
		{
			for (int j = 1; j < size + 1; ++j)
			{
				if (cityTab[i][j] == null)
				{
					System.out.print("--" + " ");
				} else
				{
					System.out.print(cityTab[i][j] + " ");
				}
			}
			System.out.print("\n");
		}
	}

}
