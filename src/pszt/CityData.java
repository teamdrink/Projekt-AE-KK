package pszt;

/**
 * Klasa z danymi odleg³oœci miast
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
	 * Zapisuje wartoœci odleg³oœci miast
	 */
	public void createList()
	{
		LoadingFile theLoadingFile = new LoadingFile();
		cityTab = theLoadingFile.loadTable();
		size= theLoadingFile.size();
	}

	/**
	 * Wyœwietla liste odleg³oœci miast
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
