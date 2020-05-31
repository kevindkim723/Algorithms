import java.io.*;
import java.util.*;


public class polygon {
	public static void main(String[] args ) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0 ;i < n; i++)
		{
			int m = Integer.parseInt(br.readLine());
			String[][] matrix = new String[m][m];
			for (int j = 0; j < m; j++)
			{
				matrix[j] = br.readLine().split("");
			}
			solve(m, matrix);

		}
	}
	public static void solve(int m, String[][] matrix)
	{
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < m; j++)
			{
				if (matrix[i][j].equals("1"))
				{
					if (i != m-1 && j != m-1)
					{
						if (!matrix[i+1][j].equals("1") && !matrix[i][j+1].equals("1"))
						{
							System.out.println("NO");
							return;
						}
					}
				}
			}
		}
		System.out.println("YES");
	}
}
