package pszt;

public class Main
{

	public static void main(String[] args)
	{
		CityData theCityData = new CityData();
		PopulationData thePopulationData = new PopulationData(theCityData);
		PathLength thePathLength = new PathLength(thePopulationData, theCityData);
		Mutation theMutation = new Mutation(thePopulationData, theCityData);
		Selection theSelection = new Selection(thePopulationData, theCityData, thePathLength);

		theCityData.createList(60);
		// theCityData.showList();

		thePopulationData.createPopulation();
		// thePopulationData.show();
		Crossbreed theCrossbreed = new Crossbreed(thePopulationData, theCityData);
		float y = 0, x = 0;
		for (int i = 0; i < 1366; ++i)
		{
			System.out.format("%05d", i);
			System.out.print(".");
			theCrossbreed.Crossbreeding();
			theSelection.addPopulation();
			theMutation.mutating();
			thePathLength.calculatePathSelection();
			theSelection.selecting();
			// thePopulationData.show();
			thePathLength.calculatePath();
			thePathLength.show();
			thePathLength.plot(i);
			if (i == 0)
			{
				x = thePathLength.min();
			}
			y = thePathLength.min() / x * 100;
			System.out.format("%.2f", y);
			System.out.print("% ");
			for (int j = 0; j < y; ++j)
			{
				System.out.print("#");
			}
			System.out.print("\n");
		}
		View theView = new View(thePathLength);
		theView.paint();
	}
}