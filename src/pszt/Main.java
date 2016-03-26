package pszt;



public class Main
{

	public static void main(String[] args)
	{
		CityData theCityData = new CityData();
		theCityData.createList(3);
		theCityData.showList();
		PopulationData thePopulationData = new PopulationData(theCityData);
		thePopulationData.createPopulation();
		thePopulationData.showPopulation();
		PathLength thePathLength = new PathLength(thePopulationData,theCityData);
		Mutation theMutation = new Mutation(thePopulationData,theCityData);
		Crossbreed theCrossbreed= new Crossbreed(thePopulationData, theCityData);
		theCrossbreed.Crossbreeding();
		theCrossbreed.show();
		thePopulationData.showPopulation();
		Selection theSelection = new Selection(thePopulationData,theCityData);
		theSelection.addPopulation();
		theSelection.show();
		thePathLength.calculatePathSelection();
		thePathLength.showX();

		
		
		
		
		/*for(int i = 0; i<10;++i){
			thePathLength.calculatePath();
			thePathLength.show();
			theMutation.mutating();
			System.out.print("\n");
		}*/
				
	}
	
}
