import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class PercolationSimulator {
	static Random r = new Random();
	static class ij
	{
		public int i;
		public int j;
		public ij(int i, int j)
		{
			this.i = i;
			this.j = j;
		}
	}

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter board length: ");
		int n = s.nextInt();
		System.out.println("Enter trials: ");
		int t = s.nextInt();
		double mean = 0;
		percolationboard pb = new percolationboard(n, true);

		for (int i=0; i < t; i ++)
		{
			pb.fill();
			mean += pb.getp();
		}
		System.out.println(mean/t);
		
		
		
		
			
			
		
	}
	public static ij generate(LinkedList<ij> set)
	{
		ij x = set.get(r.nextInt(set.size()));
		set.removeFirstOccurrence(x);
		return x;
		
	}
	
	
	
}
