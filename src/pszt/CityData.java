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
	public void createList()
	{
		LoadingFile theLoadingFile = new LoadingFile();
		cityTab = theLoadingFile.loadTable();
		size= theLoadingFile.size();
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
