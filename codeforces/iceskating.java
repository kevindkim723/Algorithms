import java.io.*;
import java.util.*;

public class iceskating {// connected components - 1

	static LinkedList<Integer>[] adj = new LinkedList[100];// adjacency list

	static int[] ycoord = new int[1001];
	static int[] xcoord = new int[1001];

	public static void main(String[] args) throws Exception {
		Arrays.fill(ycoord, -1);
		Arrays.fill(xcoord, -1);
		for (int i = 0; i < 100; i++) {
			adj[i] = new LinkedList<>();
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());

			if (xcoord[x1] != -1 || ycoord[x2] != -1)// if the node is connected
			{

				if (xcoord[x1] != -1)// if this was a previously disconnected node
				{

					adj[xcoord[x1]].add(i);// connect the node at x1 to i

					adj[i].add(xcoord[x1]);
				}

				if (ycoord[x2] != -1)// if this was a previously disconnected node
				{
					adj[ycoord[x2]].add(i);
					adj[i].add(ycoord[x2]);

				}
				xcoord[x1] = i;
				ycoord[x2] = i;
				// System.out.println("after: " + xcoord[x1]);

			}

			else// we're assuming this current node is not connected anywhere.
			{

				// System.out.println("Disconnected");
				adj[i].add(i);
				xcoord[x1] = i;// we want to fill the xcoord/ycoord however, to see if future connections will
								// make sense
				ycoord[x2] = i;

				// System.out.println(xcoord[x1]);
			}

		}
		int counter = 0;
		HashSet<Integer> visited = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {

			if (adj[i].size() != 0) {
				if (adj[i].get(0) == -1) {
					counter++;
					continue;
				}

				if (!visited.contains(i)) {
					counter++;
					comp(i, visited);
				}
			}
		}
		System.out.println(counter - 1);

	}

	public static void comp(int n, HashSet<Integer> visited) {
		if (visited.contains(n)) {
			return;
		}
		visited.add(n);
		Iterator<Integer> i = adj[n].listIterator();
		while (i.hasNext()) {
			int next = i.next();
			if (!visited.contains(next)) {
				comp(next, visited);
			}
		}
		return;

	}

	static void pf(LinkedList<Integer>[] l) {
		for (LinkedList<Integer> a : l) {

			System.out.println(a);
		}
	}
}
