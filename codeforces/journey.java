import java.io.*;
import java.util.*;

public class journey {
	static LinkedList<Integer>[] adj = new LinkedList[100001];
	static int[] heights = new int[100001];
	static double distances = 0;
	static int leaves = 0;

	// DFS to get journey length
	public static void main(String[] args) throws Exception {
		for (int i = 1; i < 100001; i++) {
			adj[i] = new LinkedList<Integer>();
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);

		}
		HashSet<Integer> visited = new HashSet<>();
		dfs(0,1, 1, visited);
		System.out.println(distances);

	}

	

	public static void dfs(int h, double prob, int node, HashSet<Integer> visited) {
		if (visited.contains(node)) {
			return;
		}
		visited.add(node);
		Iterator<Integer> itr = adj[node].listIterator();
		if (adj[node].size() == 1 && node!=1) // if leaf
		{
			distances += h*prob;
			return;
		}
		double children = 0;
		while (itr.hasNext()) {
			int subnode = itr.next();
			if (!visited.contains(subnode)) {
				children++;
			}

		}
		itr = adj[node].listIterator();
		while (itr.hasNext()) {
			int subnode = itr.next();
			if (!visited.contains(subnode)) {
				dfs(h + 1,prob * 1/children ,subnode, visited);
			}
		}
	}

}
