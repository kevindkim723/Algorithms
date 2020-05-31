import java.io.*;
import java.util.*;

public class dijkstra {
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

	static LinkedList<Node>[] adj = new LinkedList[100001];
	static int[] shortestPath = new int[100001];
	static int[] prev = new int[100001];
	
	static boolean[] visited = new boolean[100001];

	public static void main(String[] args) throws Exception {
		Arrays.fill(shortestPath, Integer.MAX_VALUE);
		Arrays.fill(prev, -1);
		for (int i = 0 ; i < 100001;i++)
		{
			adj[i] = new LinkedList<>();
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for (int i = 0; i < m; i++)//builds tree with adjacent subnodes with edge weight.
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj[a].add(new Node(b, c));
			adj[b].add(new Node(a,c));
			
		}
		prev[1] = 0;
		dk(n,m);
		//System.out.println(Arrays.toString(prev));
		LinkedList<Integer> list = new LinkedList<>();
		printp(n, list);
		
	}
	public static void dk(int n, int m)
	{
		shortestPath[n] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1, 0));
		while(pq.size()!=0)
		{
			Node curr = pq.poll();
			visited[curr.val] = true;
			Iterator<Node> i = adj[curr.val].listIterator();
			while(i.hasNext())
			{
				Node subNode = i.next();
				if (!visited[subNode.val])
				{				
					//System.out.println(subNode.val);

					if (shortestPath[subNode.val] > shortestPath[curr.val] + subNode.weight)
					{
						shortestPath[subNode.val]= shortestPath[curr.val] + subNode.weight;
						pq.add(new Node(subNode.val, shortestPath[subNode.val]));
						prev[subNode.val] = curr.val;
						
					}
					
				}
			}
		}
	}
	public static void printp( int m, LinkedList<Integer> list )
	{
	
		if (prev[m]== -1)
		{
			System.out.print(-1);
			return;
		}
		list.add(m);
		int c = prev[m];
		while (c != 1)
		{
			list.add(0, c);
			c = prev[c];
		}
		System.out.print(1 + " ");
		for (int i = 0; i < list.size(); i++)
		{
			System.out.print(list.get(i) + " ");
		}
	}
}
