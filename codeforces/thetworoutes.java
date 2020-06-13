import java.io.*;
import java.util.*;

public class thetworoutes {
	static LinkedList<Integer>[] roadTree = new LinkedList[401];
	static LinkedList<Integer>[] railTree = new LinkedList[401];
	static int[] roadHeight = new int[401];
	static int[] railHeight = new int[401];
	static int n, m;

	public static void main(String[] args) throws Exception

	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		for (int i = 1; i < 401; i++) {
			roadTree[i] = new LinkedList<>();
			railTree[i] = new LinkedList<>();

		}
		for (int i = 1; i <= n; i++)// makes all road connections prior to parsing rails.
		{
			for (int j = i; j <= n; j++) {
				if (j != i) {

					if (!roadTree[i].contains(j))
						roadTree[i].add(j);
					if (!roadTree[j].contains(i))
						roadTree[j].add(i);
				}

			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			railTree[a].add(b);
			railTree[b].add(a);

		}
		for (int i = 1; i < 401; i++) { //this is to remove the roads, we dfs on root node n, remove all those nodes from n in roadtree, then repeat for all nodes n that exist in the railtree
			dfs(i, i, new HashSet<Integer>());
		}
		pf(roadTree);

	}

	public static void dfs(int root, int n, HashSet<Integer> visited) {
		if (visited.contains(n)) {
			return;
		}
		visited.add(n);
		Iterator<Integer> itr = railTree[n].listIterator();
		while (itr.hasNext()) {
			int subnode = itr.next();
			if (!visited.contains(subnode)) {
				roadTree[subnode].remove(Integer.valueOf(root));
				roadTree[root].remove(Integer.valueOf(subnode));
				
				dfs(root, subnode, visited);
			}
		}
	}

	static void pf(LinkedList<Integer>[] l) {
		for (LinkedList<Integer> a : l) {

			System.out.println(a);
		}
	}

}
