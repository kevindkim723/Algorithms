import java.io.*;
import java.util.*;

public class buyingshovels {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
						boolean found = false;

			if (b >= a )
			{
				System.out.println("1");
			}
			else
			{
				for (int j = b; j > Math.sqrt((double) b); j-- )
				{
					
					if (a%j == 0)
					{
						found = true;
						System.out.println(a/j);
						break;
						
					}
				}
				if (!found)
				{
					System.out.println(a);
				}
			
				
			}
		}
	}
}
