package pszt;

/**
 * Klasa sprawdzaj¹ca istnienie osobnika
 */
public class Exist
{
	private CityData theCityData;

	public Exist(CityData theCityData)
	{
		this.theCityData = theCityData;
	}

	/**
	 * @param tab tablica populacji
	 * @param x	liczba miast
	 * @param y	dany osobnik
	 * @return istnienie osobnika
	 * sprawdza czy osobnik istnieje
	 */
	public boolean ifExist(Integer[][] tab, int x, int y)
	{
		for (int i = 0; i < x-1; ++i)
		{
			int lenght;

			if (tab[y][i] < tab[y][i + 1])
			{
				lenght = theCityData.cityTab[tab[y][i]][tab[y][i + 1]];
			} else
			{
				lenght = theCityData.cityTab[tab[y][i + 1]][tab[y][i]];
			}
			if(lenght==-1){
				return false;
			}
		}
		return true;
	}

}
