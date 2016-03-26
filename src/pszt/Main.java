package pszt;



public class Main
{

	public static void main(String[] args)
	{
		CityData theCityData = new CityData();
		theCityData.createList(5);
		theCityData.showList();
		PopulationData thePopulationData = new PopulationData(theCityData);
		thePopulationData.createPopulation();
		thePopulationData.showPopulation();
		PathLength thePathLength = new PathLength(thePopulationData,theCityData);
		Mutation theMutation = new Mutation(thePopulationData,theCityData);
		Crossbreed theCrossbreed= new Crossbreed(thePopulationData, theCityData);
		theCrossbreed.changeRepresentation();
		theCrossbreed.show();
		
		
		
		
		/*for(int i = 0; i<10;++i){
			thePathLength.calculatePath();
			thePathLength.show();
			theMutation.mutating();
			System.out.print("\n");
		}*/
				
	}
	
}
