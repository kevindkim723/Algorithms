import java.io.*;
import java.util.*;

public class rumor {
	static LinkedList<Integer>[] adj = new LinkedList[100001];
	static int n, m;
	static int[] coin = new int[100001];
	public static void main(String[] args ) throws Exception
	{
		for (int i = 1; i < 100001; i++)
		{
			adj[i] = new LinkedList<>();
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 1;  i <= n ; i++)
		{
			coin[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0 ; i < m ; i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adj[a].add(b);
			adj[b].add(a);
		}
		HashSet<Integer> visited = new HashSet<>();
		
		long total = 0;
		for (int i = 1; i <= n ; i++)
		{
			if(adj[i].isEmpty()) //if this node is disconnected
			{
				total+= coin[i];
			}
			else {//if node is not disconnected
				
				if (!visited.contains(i))
				{
					total += dfs(i, visited);
				}
			}
		}
		System.out.println(total);
		
	}
	public static int dfs(int node, HashSet<Integer> visited)
	{
		
		visited.add(node);
		Iterator<Integer> i = adj[node].listIterator();
		int min = coin[node];
		while (i.hasNext())
		{
			int subnode = i.next();
			if (!visited.contains(subnode))
			{
				min = Math.min(min, dfs(subnode, visited));
			}
		}
		return min;
	}
}
