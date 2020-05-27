import java.io.*;
import java.util.*;

public class lovetriangle {
	static int[] arr = new int[5001];
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <=n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		HashSet<Integer> visited = new HashSet<>();
		Stack<Integer> stack = new Stack<>();
		for (int i = 1; i <=n;i++)
		{
			stack.clear();
			if (cycle(i, visited, stack))
			{
				System.out.println("Yes");
				return;
			}
		}
		System.out.println("NO");


		
	}
	public static boolean cycle(int index, HashSet<Integer> visited, Stack<Integer> stack)
	{
		if (stack.contains(index) && stack.size() >=3 && stack.get(stack.size()-3) == index)
		{
			return true;
		}
		if (stack.contains(index) || visited.contains(index))
		{
			return false;
		}
		
		stack.push(index);
		visited.add(index);
		
		return cycle(arr[index], visited, stack);
	}
}

