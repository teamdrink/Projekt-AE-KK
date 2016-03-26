package pszt;

public class Selection
{
	private PopulationData thePopulationData;
	private CityData theCityData;
	private PathLength thePathLength;


	public Selection(PopulationData thePopulationData, CityData theCityData)
	{
		this.thePopulationData = thePopulationData;
		this.theCityData = theCityData;
	}

	public void addPopulation(){
		for (int i = 0; i < thePopulationData.size; ++i)
		{
			for (int j = 0; j < theCityData.size; ++j)
			{

				thePopulationData.popTabAction[i][j]=thePopulationData.popTabOld[i][j];
			}
		}
		for (int i = thePopulationData.size; i < thePopulationData.size*2; ++i)
		{
			for (int j = 0; j < theCityData.size; ++j)
			{

				thePopulationData.popTabAction[i][j]=thePopulationData.popTab[i-thePopulationData.size][j];
			}
		}
	}
	
	public void show(){
		for (int i = 0; i < thePopulationData.size*2; ++i)
		{
			for (int j = 0; j < theCityData.size; ++j)
			{
				System.out.print(thePopulationData.popTabAction[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	
	public void selecting(){
		thePathLength.calculatePathSelection();
	}
	
}
