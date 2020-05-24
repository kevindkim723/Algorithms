import java.util.*;
import java.io.*;

public class party {
	static LinkedList<Integer> tree[] = new LinkedList[2001];
	public static void main(String[] args) throws Exception {
		BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(fin.readLine());
		boolean[] roots = new boolean[2001];
	
		for (int i = 1 ; i <= n ; i++) {
				if (tree[i] == null)
				{
					tree[i] = new LinkedList<Integer>();
				}
				int x = Integer.parseInt(fin.readLine());
				if (x!=-1 && tree[x] == null) {
					tree[x] = new LinkedList<Integer>();
				}
				if (x!=-1) {
					tree[i].add(x);
					tree[x].add(i);
				}
				else
				{
					roots[i] = true;
				}
		}
		int mH = -1;
		//pf(tree);
		for (int i = 1; i <= n; i++)
		{
			if (roots[i])
			{
			HashSet<Integer> visited = new HashSet<>();

			mH = Math.max(mH, height(i, visited));
			}
		}
		System.out.println(mH);
		
	}
	public static int height(int pos, HashSet<Integer> visited)
	{
		visited.add(pos);
		int height = 1;
		Iterator<Integer> i = tree[pos].listIterator(); 
		int mH =0;
		while (i.hasNext())
		{
			int n = i.next();
	
			if (!visited.contains(n))
			{
				mH = Math.max(height(n,visited), mH);
			}
		
		}
		//after this loop executes mH should hold the highest height for all of [pos] subnodes
		return height +mH;

	}
	static void pf(LinkedList<Integer>[] l)
	{
		for (LinkedList<Integer> a : l)
		{
			
			System.out.println(a);
		}
	}


}
