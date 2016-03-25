package pszt;

public class PathLength
{
	private PopulationData thePopulationData;
	private CityData theCityData;

	Integer[] pathLenght;
	
	public PathLength(PopulationData thePopulationData, CityData theCityData)
	{
		this.thePopulationData = thePopulationData;
		this.theCityData = theCityData;
		pathLenght = new Integer[thePopulationData.populationSize];

	}


	public void calculatePath()
	{
		for (int i = 0; i < thePopulationData.populationSize; ++i)
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

	public void show()
	{
		for (int i = 0; i < thePopulationData.populationSize; ++i)
		{
			System.out.print(pathLenght[i] + "\n");
		}
	}

}
