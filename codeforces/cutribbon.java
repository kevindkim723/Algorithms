import java.io.*;
import java.util.*;

public class cutribbon {
	static int[] dp = new int[4001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a, b, c, d;
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		d = Integer.parseInt(st.nextToken());
		Arrays.fill(dp, Integer.MIN_VALUE);

		dp[0] = 0;
		for (int i = b; i <= a; i++) {
			dp[i] = Math.max(dp[i - b] + 1, dp[i]);
		}
		for (int i = c; i <= a; i++) {
			dp[i] = Math.max(dp[i - c] + 1, dp[i]);
		}
		for (int i = d; i <= a; i++) {
			dp[i] = Math.max(dp[i - d] + 1, dp[i]);
		}
		System.out.println(dp[a]);

	}

}
