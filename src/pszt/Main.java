package pszt;

import java.util.zip.Inflater;

public class Main
{

	public static void main(String[] args)
	{
		CityData theCityData = new CityData();
		PopulationData thePopulationData = new PopulationData(theCityData);
		PathLength thePathLength = new PathLength(thePopulationData, theCityData);
		Mutation theMutation = new Mutation(thePopulationData, theCityData);
		Selection theSelection = new Selection(thePopulationData, theCityData, thePathLength);

		theCityData.createList(50);
		//theCityData.showList();

		thePopulationData.createPopulation();
		//thePopulationData.showPopulation();
		Crossbreed theCrossbreed = new Crossbreed(thePopulationData, theCityData);

		for (int i = 0; i < 100; ++i)
		{
			theCrossbreed.Crossbreeding();
			theSelection.addPopulation();
			theMutation.mutating();
			thePathLength.calculatePathSelection();
			theSelection.selecting();
			// thePopulationData.showPopulation();
			thePathLength.calculatePath();
			thePathLength.show();
		}

	}

}
