package pszt;

/**
 * Klasa z danymi odległości miast
 */
public class CityData
{
	/**
	 * Liczba miast
	 */
	public int size;

	Integer[][] cityTab;


	/**
	 * @param x liczba miast
	 * Zapisuje wartości odległości miast
	 */
	public void createList(int x)
	{
		size = x;
		cityTab = new Integer[x][x];
		RandomCity theRandomCity = new RandomCity();
		theRandomCity.randomCity(cityTab, x);
	}

	/**
	 * Wyświetla liste odległości miast
	 */
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
