import java.io.*;
import java.util.*;

public class childandtoy {
	static int n, m;
	static LinkedList<Integer>[] adj = new LinkedList[1001];
	static int[] weights = new int[1001];
	static int[] cweights = new int[1001];

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= n; i++) {
			adj[i] = new LinkedList<>();
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			weights[i] = Integer.parseInt(st.nextToken());

		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);

		}
		for (int i = 1; i <= n; i++) {
			int connectedw = 0;
			for (int x : adj[i]) {
				connectedw += weights[x];
			}
			cweights[i] = connectedw;

		}
		HashSet<Integer> visited = new HashSet<Integer>();
		int total = 0;
		for (int i = 0 ; i < n; i++)
		{
			int lw = Integer.MIN_VALUE;
			int node = -1;
			for (int j = 1; j <=n;j++)
			{
				if (weights[j] > lw && !visited.contains(j))
				{
					/*
					 * if (cweights[j] == lw) { if (weights[j] > weights[node]) { lw = cweights[j];
					 * node = j; continue; } else { continue; } }
					 */
					lw = weights[j];
					node = j;
					
				}
			}
			visited.add(node);
			total += cweights[node];
			for (int x : adj[node])
			{
				cweights[x] -= weights[node];
			}
			cweights[node] = 0;
			weights[node] = 0;
			
		}
		System.out.println(total);

	}
}
