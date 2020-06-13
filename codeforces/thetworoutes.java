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
		Arrays.fill(roadHeight, -1);
		Arrays.fill(railHeight, -1);
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
			roadTree[a].remove(Integer.valueOf(b));
			roadTree[b].remove(Integer.valueOf(a));

		}

		Queue<Integer> queue = new LinkedList<>();
		HashSet<Integer> visited = new HashSet<Integer>();
		queue.add(1);
		railHeight[1] = 0;
		visited.add(1);
		while (!queue.isEmpty()) {
			int node = queue.poll();
			Iterator<Integer> itr = railTree[node].listIterator();
			while (itr.hasNext()) {
				int subnode = itr.next();
				if (!visited.contains(subnode)) {
					visited.add(subnode);
					queue.add(subnode);
					railHeight[subnode] = railHeight[node] + 1;
				}
			}

		}
		queue.clear();
		visited.clear();
		queue.add(1);
		roadHeight[1] = 0;
		visited.add(1);
		while (!queue.isEmpty()) {
			int node = queue.poll();
			Iterator<Integer> itr = roadTree[node].listIterator();
			while (itr.hasNext()) {
				int subnode = itr.next();
				if (!visited.contains(subnode)) {
					visited.add(subnode);
					queue.add(subnode);
					roadHeight[subnode] = roadHeight[node] + 1;
				}
			}

		}
		if (roadHeight[n] == -1 || railHeight[n] == -1) {
			System.out.println(-1);
			return;
		}
		System.out.println(Math.max(roadHeight[n], railHeight[n]));

	}

	static void pf(LinkedList<Integer>[] l) {
		for (LinkedList<Integer> a : l) {

			System.out.println(a);
		}
	}

}
