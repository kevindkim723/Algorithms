import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;
public class anewyeartransportation {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n,m;
		String[] x;
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = br.readLine().split(" ");
		int[] arr = new int[n-1];
		for (int i = 0; i < x.length; i++) {
				arr[i] = Integer.parseInt(x[i]);
			
		}
		System.out.println(search(m, 0, arr) ? "YES" : "NO");
		

	}
	public static boolean search(int a, int index, int[] arr) {
		if (index == a-1)
		{
			return true;
		}
		if (index >= arr.length)
		{
			return false;
		}
		
		return search(a, index + arr[index], arr);
		
	}

}
