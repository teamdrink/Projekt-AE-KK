package pszt;

import java.io.File;
import java.util.Scanner;

public class LoadingFile
{
	private int a;

	public Integer[][] loadTable()
	{
		Integer[][] table = null;
		try
		{
			File file = new File("a.txt");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(file);

			a = scanner.nextInt();

			table = new Integer[a][a];

			for (int i = 0; i < a; ++i)
			{
				for (int j = i; j < a; ++j)
				{
					table[i][j] = scanner.nextInt();
				}

			}

		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return table;

	}

	public int size()
	{
		return a;
	}

}
