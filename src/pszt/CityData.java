package pszt;

public class CityData
{
	public int X;

	Integer[][] tab;

	public void createList(int x)
	{
		X = x;
		tab = new Integer[x + 1][x + 1];
		RandomCity theRandomCity = new RandomCity();
		theRandomCity.randomCity(tab, x);
	}

	public void showList()
	{
		for (int i = 1; i < X + 1; ++i)
		{
			for (int j = 1; j < X + 1; ++j)
			{
				if (tab[i][j] == null)
				{
					System.out.print("--" + " ");
				} else
				{
					System.out.print(tab[i][j] + " ");
				}
			}
			System.out.print("\n");
		}
	}

}
