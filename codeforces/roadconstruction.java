import java.io.*;
import java.util.*;

public class roadconstruction {
	static int n,m;

	static int roads =0;

	static LinkedList<Integer>[] tree = new LinkedList[1001];
	public static void main(String[] args) throws Exception
	{
		LinkedList<Integer> nr = new LinkedList<>();
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		for (int i = 0; i < m; i++)
		{
			st = new StringTokenizer(br.readLine());
			int a  = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			nr.add(a);
			nr.add(b);
		}
		int root = -1;
		for (int i = 1; i <= n ; i++)
		{
			if (!nr.contains(i))
			{
				root = i;
				break;
			}
		}

		for (int i = 1; i <= n; i++)
		{
			if (i!=root)
			{
			tree[root].add(i);
			roads++;
			}
			
		}
		print();
		
	}
	public static void print()
	{
		System.out.println(roads);
		for (int i = 1; i < 1001; i++)
		{
			Iterator itr = tree[i].listIterator();
			while (itr.hasNext())
			{
				System.out.println(i + " " + itr.next() );
			}
		}
	}

}
