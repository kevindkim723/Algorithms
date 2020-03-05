import java.io.*;
import java.util.*;

public class bees2 {

	static class Node implements Comparable<Node> {
		int val;
		int weight;

		public Node(int val, int weight) {
			this.val = val;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node arg0) {
			// TODO Auto-generated method stub
			return -(arg0.weight - weight);
		}

		public String toString() {
			return "val: " + val + "\nweight: " + weight;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("bees.in"));
		int h = Integer.parseInt(br.readLine());
		int nodes = h * (h + 1) / 2;
		LinkedList<Node> adj[] = new LinkedList[nodes];
		int[] weights = new int[nodes];

		String l = null;
		int counter = 0;
		while ((l = br.readLine()) != null) {
			String[] arr = l.split(",");
			for (int i = 0; i < arr.length; i++) {
				weights[counter] = Integer.parseInt(arr[i]);
				counter++;
			}
		}
		for (int i = 0; i < nodes; i++) {
			adj[i] = new LinkedList<>();
		}
		int currNode = 0;
		for (int i = 0; i < h - 1; i++) {
			for (int j = 0; j < i + 1; j++) {
				adj[currNode].add(new Node(i + 1 + currNode, weights[i + 1 + currNode]));// root --- left sub-node
				adj[i + 1 + currNode].add(new Node(currNode, weights[currNode]));

				// System.out.println("Counter: " + currNode + "right: " + (i+2));
				adj[currNode].add(new Node(i + 2 + currNode, weights[i + 2 + currNode]));// root --- right sub-node
				adj[i + 2 + currNode].add(new Node(currNode, weights[currNode]));

				adj[i + 1 + currNode].add(new Node(i + 2 + currNode, weights[i + 2 + currNode]));// left sub-node ---
																									// right sub-node
				adj[i + 2 + currNode].add(new Node(i + 1 + currNode, weights[i + 1 + currNode]));
				currNode++;
			}
		}
		for (int i = 0; i < adj.length; i++) {
			System.out.println(i + " " + adj[i]);
		}
		int[] paths = shortestPath(adj, nodes, 0, weights);
		int total = paths[nodes - 1] + paths[nodes - h];
		paths = shortestPath(adj, nodes, nodes - 1, weights);
		total += paths[nodes - h] - weights[0] - weights[nodes - 1] - weights[nodes - h];
		System.out.println(total);

	}

	public static int[] shortestPath(LinkedList<Node> adj[], int nodes, int x, int[] weights) {
		int[] shortestDistances = new int[nodes];
		Arrays.fill(shortestDistances, Integer.MAX_VALUE);
		boolean[] visited = new boolean[nodes];
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(x, weights[x]));
		shortestDistances[x] = weights[x];

		while (pq.size() != 0) {
			Node curr = pq.poll();
			visited[curr.val] = true;
			// System.out.println("root: " + curr.val);
			Iterator<Node> i = adj[curr.val].listIterator();
			while (i.hasNext()) {
				Node subNode = i.next();
				if (!visited[subNode.val]) {
					if (shortestDistances[subNode.val] > subNode.weight + shortestDistances[curr.val]) {

						shortestDistances[subNode.val] = subNode.weight + shortestDistances[curr.val];
						// System.out.println("Weight of " + subNode + " is now: " + (weights[subNode] +
						// shortestDistances[curr.val]));
						pq.add(new Node(subNode.val, subNode.weight + shortestDistances[curr.val]));

					}
				}
			}

		}
		System.out.println(Arrays.toString(shortestDistances));
		return shortestDistances;

	}
}