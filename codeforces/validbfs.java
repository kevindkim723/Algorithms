import java.io.*;
import java.util.*;

public class validbfs {
	static LinkedList<Integer>[] adj = new LinkedList[200001];
	static int[] roots = new int[200001];
	static int[] childrens = new int[200001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i <= 200000; i++) {
			adj[i] = new LinkedList<>();
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
		if (arr[0] != 1) {
			System.out.println("No");
			return;
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		HashSet<Integer> visited = new HashSet<>();
		visited.add(1);
		roots[1] = 1;
		while (!queue.isEmpty()) {
			int node = queue.poll();
			Iterator<Integer> itr = adj[node].listIterator();
			int numchild = 0;
			while (itr.hasNext()) {
				int x = itr.next();
				if (!visited.contains(x)) {
					queue.add(x);
					visited.add(x);
					roots[x] = node;
					numchild++;

				}
			}
			childrens[node] = numchild;
		}

		int c = 1;
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		while (!q.isEmpty()) {
			int p = q.poll();

			int i;
			for (i = c; i < childrens[p] + c; i++) {

				if (roots[arr[i]] != p) {
					System.out.println("No");
					return;
				}
				q.add(arr[i]);
			}

			c = i;
		}
		System.out.println("Yes");

	}

}
