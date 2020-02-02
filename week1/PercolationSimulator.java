import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class PercolationSimulator {
	static Random r = new Random();

	public static void main(String[] args)
	{
		LinkedList<Integer> rows = new LinkedList<Integer>();
		LinkedList<Integer> cols = new LinkedList<Integer>();
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter board length: ");
		int n = s.nextInt();
		for (int i = 0; i < n; i++)
		{
			rows.add(i);
			cols.add(i);
		}
		
		boolean[][] board = new boolean[n][n];
		QuickUnionPathCompression nodes = new QuickUnionPathCompression(n*n+2);
		
		while (nodes.connected(0, n*n+1) == false && rows.size()!=0)
		{
			int rowfill = generate(rows);
			int colfill = generate(cols);
			board[rowfill][colfill] = true;

			int nodeIndex = rowfill * (n) + colfill + 1;
			
			
			if (rowfill == 0)
			{
				nodes.merge(nodeIndex, 0);
			}
			else if (rowfill == n-1)
			{
				nodes.merge(nodeIndex, n+1);
				if ()
			}
			
			else
			{
				
			}
			System.out.println(rowfill);
			
		}
	}
	public static int generate(LinkedList<Integer> set)
	{
		int x = set.get(r.nextInt(set.size()));
		set.removeFirstOccurrence(x);
		return x;
		
	}
}
