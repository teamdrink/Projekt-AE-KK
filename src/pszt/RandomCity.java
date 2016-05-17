package pszt;

import java.util.Random;

public class RandomCity
{

	public int random(int x)
	{
		Random r = new Random();
		return r.nextInt(x);
	}

	public void randomCity(Integer[][] tab, int x)
	{
		for (int i = 0; i < x; ++i)
		{
			for (int j = i; j < x ; ++j)
			{
				tab[i][j] = random(100)-10;
				if (tab[i][j] < 0){
					tab[i][j] = -1;
				}
			}
		}
	}

}
