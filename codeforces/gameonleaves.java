import java.io.*;
import java.util.*;

public class gameonleaves {
	static int t;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			LinkedList<Integer>[] adj = new LinkedList[1001];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= n; j++) {
				adj[j] = new LinkedList<>();

			}
			int specnode = Integer.parseInt(st.nextToken());
			for (int j = 0 ; j < n-1; j++)
			{
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adj[a].add(b);
				adj[b].add(a);
			}
			if (adj[specnode].size() == 1 || adj[specnode].isEmpty())
			{
				System.out.println("Ayush");
				continue;
			}
			if (n%2 ==0)
			{
				System.out.println("Ayush");
				
			}
			else
			{
				System.out.println("Ashish");
			}
		}

	}

}
