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
		int a,b,x,y;
		for (int i = 0; i < thePopulationData.size; ++i)
		{	
			a=random(theCityData.size);
			b=random(theCityData.size);
			x=thePopulationData.popTabAction[i][a];
			y=thePopulationData.popTabAction[i][b];
			thePopulationData.popTabAction[i][b]=x;
			thePopulationData.popTabAction[i][a]=y;
		}
		
	}
}
