package pszt;

/**
 * Klasa licz¹ca d³ugoœci scie¿ek
 */
public class PathLength
{
	private PopulationData thePopulationData;
	private CityData theCityData;

	Integer[] pathLenght,pathLenghtAction;
	
	public PathLength(PopulationData thePopulationData, CityData theCityData)
	{
		this.thePopulationData = thePopulationData;
		this.theCityData = theCityData;
		pathLenght = new Integer[thePopulationData.size];
		pathLenghtAction = new Integer[(thePopulationData.size)*2];
	}


	public void calculatePath()
	{
		for (int i = 0; i < thePopulationData.size; ++i)
		{
			pathLenght[i]=0;
			for (int j = 0; j < theCityData.size - 1; ++j)
			{
				if (thePopulationData.popTab[i][j] < thePopulationData.popTab[i][j + 1])
				{
					pathLenght[i] += theCityData.cityTab[thePopulationData.popTab[i][j]][thePopulationData.popTab[i][j+ 1]];
				} else
				{
					pathLenght[i] += theCityData.cityTab[thePopulationData.popTab[i][j+ 1]][thePopulationData.popTab[i][j]];
				}
			}
		}
	}
	
	public void calculatePathSelection()
	{
		for (int i = 0; i < thePopulationData.size*2; ++i)
		{
			pathLenghtAction[i]=0;
			for (int j = 0; j < theCityData.size - 1; ++j)
			{
				if (thePopulationData.popTabAction[i][j] < thePopulationData.popTabAction[i][j + 1])
				{
					pathLenghtAction[i] += theCityData.cityTab[thePopulationData.popTabAction[i][j]][thePopulationData.popTabAction[i][j+ 1]];
				} else
				{
					pathLenghtAction[i] += theCityData.cityTab[thePopulationData.popTabAction[i][j+ 1]][thePopulationData.popTabAction[i][j]];
				}
			}
		}
	}

	public void show()
	{
		System.out.format("max:%04d min:%04d", max(),min());
		//System.out.print("max:"+max()+ " min:"+ min()+" ");
	}
	
	public void showX()
	{
		for (int i = 0; i < thePopulationData.size*2; ++i)
		{
			System.out.print(pathLenghtAction[i] + " ");
		}

	}

	
	public int max(){
		int wynik = pathLenght[0];
		for (int i = 1; i < thePopulationData.size; ++i)
		{
			if (wynik <pathLenght[i]) {
			wynik = pathLenght[i];
			}
		}
		return wynik;
	}
	public int min(){
		int wynik = pathLenght[0];
		for (int i = 1; i < thePopulationData.size; ++i)
		{
			if (wynik >pathLenght[i]) {
			wynik = pathLenght[i];
			}
		}
		return wynik;
	}
	
	Integer[][] x= new Integer[10000][2];
	public void plot(int i){
		x[i][0]=max();
		x[i][1]=min();
		
	}
}
