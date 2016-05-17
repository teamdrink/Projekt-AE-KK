package pszt;

import java.util.Random;

/**
 * Algorytm mutacji
 */
public class Mutation
{

	private PopulationData thePopulationData;
	private CityData theCityData;
	private Exist theExist;

	public Mutation(PopulationData thePopulationData, CityData theCityData,Exist theExist)
	{
		this.thePopulationData = thePopulationData;
		this.theCityData = theCityData;
		this.theExist = theExist;
	}

	public int random(int x)
	{
		Random r = new Random();
		return r.nextInt(x);
	}

	public void mutating()
	{
		int a=0, b=0, x=0, y=0;
		for (int i = 0; i < thePopulationData.size; ++i)
		{
			int j;
			for(j=0;(j<10 || (theExist.ifExist(thePopulationData.popTabAction,theCityData.size,i) == false));++j){
				if(j!=0){
					thePopulationData.popTabAction[i][b] = y;
					thePopulationData.popTabAction[i][a] = x;
				}
				a = random(theCityData.size);
				b = random(theCityData.size);
				x = thePopulationData.popTabAction[i][a];
				y = thePopulationData.popTabAction[i][b];
				thePopulationData.popTabAction[i][b] = x;
				thePopulationData.popTabAction[i][a] = y;
			}
			if(j==10){
				thePopulationData.popTabAction[i][b] = y;
				thePopulationData.popTabAction[i][a] = x;
			}
			//} while (theExist.ifExist(thePopulationData.popTabAction,theCityData.size,i) != true);
		}

	}
}
