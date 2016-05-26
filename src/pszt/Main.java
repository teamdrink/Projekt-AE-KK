package pszt;

/**
 * Porojekt PSZTY
 * Algorytm ewolucyjny
 * Komiwoja¿er
 */
public class Main
{

	/**
	 * G³ówna pêtla programu
	 */
	public static void main(String[] args)
	{
		final int iterationSize = 1366;
		final int populationSize =1000;
//1500,200,2%
//1500,400,1%
//2000,100,5%
//500,25,30%
//4000,800,0%
//2000,400,0%
		
		
		LoadingFile a =new LoadingFile();
		
		CityData theCityData = new CityData();
		PopulationData thePopulationData = new PopulationData(theCityData, populationSize);
		PathLength thePathLength = new PathLength(thePopulationData, theCityData);
		Mutation theMutation = new Mutation(thePopulationData, theCityData);
		Selection theSelection = new Selection(thePopulationData, theCityData, thePathLength);

		theCityData.createList();
		theCityData.showList();

		thePopulationData.createPopulation();
		//thePopulationData.show();

		System.out.print("Rozpoczêcie ewolucji ...\n");
		
		Crossbreed theCrossbreed = new Crossbreed(thePopulationData, theCityData);
		float y = 0, x = 0;
		for (int i = 0; i < iterationSize; ++i)
		{
			System.out.format("%05d", i+1);
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