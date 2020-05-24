import java.util.*;
import java.io.*;

public class presentfromlena {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		for (int i = 0; i < n+1; i++)
		{
			int j = 2*n-(i*2);
			for (int k = 0; k < j-1 ; k++)
			{
				if (i!= n)System.out.print(" ");
			}
			for (int l = 0; l < i; l++)
			{
				if (i==n && l==0) System.out.print(l);
				else System.out.print(" " + l );
			}
			for (int l = i; l >= 0; l--)
			{
					System.out.print( " " + l );

			}
			System.out.println();
		}
		for (int i = n-1; i >=0; i--)
		{
			int j = 2*n-(i*2);
			for (int k = 0; k < j-1 ; k++)
			{
				System.out.print(" ");
			}
			for (int l = 0; l < i; l++)
			{
				System.out.print(" " + l);
			}
			for (int l = i; l >= 0; l--)
			{
					System.out.print(" " + l);

			}
			System.out.println();
		}
	}

}
