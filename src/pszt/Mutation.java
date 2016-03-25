package pszt;

import java.util.Random;

public class Mutation
{

	private PopulationData thePopulationData;
	private CityData theCityData;
	
	public Mutation(PopulationData thePopulationData, CityData theCityData){
		this.thePopulationData = thePopulationData;		
		this.theCityData = theCityData;
	}
	
	public int random(int x)
	{
		Random r = new Random();
		return r.nextInt(x);
	}
	
	public void mutating(){
		int a,b;
		for (int i = 0; i < thePopulationData.size; ++i)
		{	
			a=random(theCityData.size);
			b=random(theCityData.size);

			thePopulationData.popTab[i][b]=thePopulationData.popTabOld[i][a];
			thePopulationData.popTab[i][a]=thePopulationData.popTabOld[i][b];
		}
		thePopulationData.popTabOld = thePopulationData.popTab;
	}
}
