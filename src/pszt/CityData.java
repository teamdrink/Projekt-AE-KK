package pszt;

public class CityData
{
	public int size;

	Integer[][] cityTab;


	public void createList(int x)
	{
		size = x;
		cityTab = new Integer[x][x];
		RandomCity theRandomCity = new RandomCity();
		theRandomCity.randomCity(cityTab, x);
	}

	public void showList()
	{
		for (int i = 0; i < size; ++i)
		{
			for (int j = 0; j < size; ++j)
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
