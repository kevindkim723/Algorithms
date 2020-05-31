import java.io.*;
import java.util.*;

public class badge {
	static int[] arr = new int[1001];
	public static void main(String[] args ) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i  <= n; i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= n; i++)
		{
			HashSet<Integer> visited = new HashSet<Integer>();
			System.out.print(dfs(i, visited) + " ");
		}
	}
	public static int dfs(int n, HashSet<Integer> visited)
	{
		if (visited.contains(n))
		{
			return  n;
		}
		visited.add(n);
		return (dfs(arr[n], visited));
	}

}
