import java.io.*;
import java.util.*;
public class twobuttons {
	static	LinkedList<Integer>[] adj = new LinkedList[10000];

	public static void main(String[] args ) throws IOException {
		BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(fin.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		for (int i = 0 ; i < adj.length; i++ ) {
			adj[i] = new LinkedList<>();
			
		}
		HashSet<Integer> v = new HashSet<Integer>();
		build(n, m, v);
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] distances = new int[10000];
		distances[n] = 0;
		queue.add(n);
		while (!queue.isEmpty())
		{
			int x = queue.poll();
			if (x == m)
			{
				distances[m] = distances[x];
				break;
			}
			for (int i : adj[x])
			{
				queue.add(i);
				distances[i] = distances[x] + 1;
			}
			
		}
		System.out.println(distances[m]);
		
		pf(adj);
		

	}
	//builds tree
	public static void build(int n, int m, HashSet<Integer> visited)
	{
		if (n >=100 || n <= 0 || visited.contains(n) || n==m)
		{
			return ;
		}
		adj[n].add(n-1);
		adj[n].add(n*2);
		
		visited.add(n);
		
		build(n-1, m, visited);
		build(n*2, m, visited);

	}
	//helper method to print
	static void pf(LinkedList<Integer>[] l)
	{
		for (LinkedList<Integer> a : l)
		{
			
			System.out.println(a);
		}
	}

}
