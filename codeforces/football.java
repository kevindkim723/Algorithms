import java.io.*;
import java.util.*;

public class football {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		
		int counter = 1;
		char prevc = s.charAt(0);
		for (int i = 1; i < s.length(); i++)
		{
				if (s.charAt(i) == prevc)
				{
					counter++;
				}
				else
				{
					prevc = s.charAt(i);
					counter = 1;
				}
				
				if(counter==7)
				{
					System.out.println("YES");
					return;
				}
		}
		System.out.println("NO");
		
	}

}
