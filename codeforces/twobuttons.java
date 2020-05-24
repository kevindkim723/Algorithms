import java.io.*;
import java.util.*;
public class twobuttons {
	static	LinkedList<Integer>[] adj = new LinkedList[20000];

	public static void main(String[] args ) throws IOException {
		BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(fin.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] distances = new int[20000];
		Arrays.fill(distances, -1);
		distances[n] = 0;
		queue.add(n);

		while (!queue.isEmpty())
		{
			int x = queue.poll();

			
			int a = x -1;
			int b = x *2;
			
			if (x == m)
			{
				break;
			}
			
			if (distances[a] == -1 && a > 0)
			{
				queue.add(a);
				distances[a] = distances[x] + 1;
			}
			if (b >= 20000)
			{
				continue;
			}
			
			if(distances[b] == -1 ) {
				queue.add(b);
				distances[b] = distances[x]+1;
			}
			
			
		}
		System.out.println(distances[m]);
		
		

	}
	

}
