import java.io.*;
import java.util.*;
public class boredom {
	static long[] arr = new long[100001];
	static long[] dp = new long[100001];
	static long n ;
	static long[] count = new long[100001];
	public static void main(String[] args) throws Exception
	{
		Arrays.fill(count, 0L);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int l = -1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <=n; i++)
		{
			int x = Integer.parseInt(st.nextToken());
			l = Math.max(x,l);
			arr[i] = x;
			count[x]+=1;
		}
		dp[0] = 0;
		dp[1] = count[1];
		for (int i = 2 ; i <=l ; i++)
		{
			
			dp[i] = Math.max( dp[i-2] + count[i] *  i, dp[i-1]);
		}
		System.out.println(dp[l]);
	

		
	}
}
