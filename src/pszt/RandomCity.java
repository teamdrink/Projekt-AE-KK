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
		for (int i = 1; i < x; ++i)
		{
			for (int j = i + 1; j < x + 1; ++j)
			{
				tab[i][j] = random(90) + 10;
			}
		}
	}

}
