package pszt;

public class Main
{

	public static void main(String[] args)
	{
		CityData theCityData = new CityData();
		theCityData.createList(30);
		theCityData.showList();
		PopulationData thePopulationData = new PopulationData(theCityData);
		thePopulationData.createPopulation();
		thePopulationData.showPopulation();
	}
}
