import java.io.*;
import java.util.*;
public class kefaandpark {
	static LinkedList<Integer> adj[] = new LinkedList[100001];
	static int[] cats;
	static int m;
	public static void main(String[] args ) throws Exception
	{
		for (int i = 0; i < adj.length; i++) {
		adj[i] = new LinkedList<Integer>();
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		cats = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			cats[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < n-1; i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
			
		}
		HashSet<Integer> visited = new HashSet<Integer>();

		
		System.out.println(path(1,0,visited));

		
	}
	public static int path(int index, int cont, HashSet<Integer> visited)
	{
		//System.out.println("cont: " + cont);
		visited.add(index);
		if (cats[index] == 1)
		{
			cont += 1;
		}
		else {
			cont = 0;
		}
		if (cont == m+1)
		{
			//if continuity is exceeded then we return 0, and break out of this node.
			//System.out.println("cont exceeded at sn:" + index);
			
			return 0;
		}
		Iterator<Integer> iterator = adj[index].listIterator();
		if (adj[index].size() == 1 && index!=1)
		{
			//System.out.println("leaf " + index);
			//this means this node is leaf, and this node is reachable.
			return 1;
		}
		int res = 0;
		while (iterator.hasNext())
		{
			int subnode = iterator.next();
			
			if (!visited.contains(subnode))
			{
				//System.out.println("sn: " + subnode);
				res += path(subnode, cont,  visited);
			}
		}
	    return res;	
	}

	static void pf(LinkedList<Integer>[] l) {
		for (LinkedList<Integer> a : l) {

			System.out.println(a);
		}
	}

}
