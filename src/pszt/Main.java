package pszt;

/**
 * @author Porojekt PSZTY
 * Algorytm ewolucyjny
 * Komiwoja¿er
 */
public class Main
{

	public static void main(String[] args)
	{
		final int populationSize =2000, citySize =100, iterationSize = 1366;

		CityData theCityData = new CityData();
		PopulationData thePopulationData = new PopulationData(theCityData, populationSize);
		PathLength thePathLength = new PathLength(thePopulationData, theCityData);
		Mutation theMutation = new Mutation(thePopulationData, theCityData);
		Selection theSelection = new Selection(thePopulationData, theCityData, thePathLength);

		theCityData.createList(citySize);
		theCityData.showList();

		thePopulationData.createPopulation();
		//thePopulationData.show();
		Crossbreed theCrossbreed = new Crossbreed(thePopulationData, theCityData);
		float y = 0, x = 0;
		for (int i = 0; i < iterationSize; ++i)
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
			if (y < 100)
				System.out.format(" %.2f", y);
			else
				System.out.format("%.2f", y);
			System.out.print("% ");
			for (int j = 0; j < 100; ++j)
			{
				if (j < y)
					System.out.print("#");
				else
					System.out.print(" ");
			}
			System.out.print("|\n");
		}
		//thePopulationData.show();
		View theView = new View(thePathLength);
		theView.paint();
	}
}