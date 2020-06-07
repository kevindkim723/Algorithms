import java.io.*;
import java.util.*;

public class validbfs {
	static LinkedList<Integer>[] adj = new LinkedList[100001];
	static LinkedList<Integer>[] hnode = new LinkedList[100001];
	static int[] heights = new int[100001];
	static int[] roots =  new int[100001];
	static int[] childrens = new int[100001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i <= 100; i++) {
			adj[i] = new LinkedList<>();
			hnode[i] = new LinkedList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		HashSet<Integer> visited = new HashSet<>();
		visited.add(1);
		heights[1] = 0;
		roots[1] = 1;
		while (!queue.isEmpty()) {
			int node = queue.poll();
			hnode[heights[node]].add(node);
			Iterator<Integer> itr = adj[node].listIterator();
			int numchild = 0;
			while (itr.hasNext()) {
				int x = itr.next();
				if (!visited.contains(x)) {
					queue.add(x);
					visited.add(x);
					heights[x] = heights[node] + 1;
					roots[x] = node;
					numchild++;

				}
			}
			childrens[n] = numchild;
		}

		//pf(hnode);

		int c = 0;
		Queue<Integer> q = new LinkedList<>();
		//System.out.println("h: " + heights[n]);
		for (int i = 0; i <= heights[n]; i++) {
			//System.out.println("i: " + i);
			int j = hnode[i].size();
			System.out.println("j: " + j);
			int k = 0;

			//System.out.println(j + c);

			int parent = queue.poll();
			int parentsize = adj[parent].size();
			for (k = c; k < j + c; k++) { //run through this loop everytime new height is reached
				if ()

				
				//System.out.println("K: " + k);
				q.add(arr[k]);
				if (!hnode[i].contains(arr[k]) ||  ) {
					System.out.println("No");

					return;
				}
			}
			c += j;

		}
		System.out.println("Yes");

	}

	static void pf(LinkedList<Integer>[] l) {
		for (LinkedList<Integer> a : l) {

			if (a != null)
				System.out.println(a);
		}
	}

}
