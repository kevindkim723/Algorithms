
/*
 * Kevin Kim bruh
 * This uses floodfill algorithm.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Mowing {
	public static void main(String[] args) throws Exception {
		long startTime = System.nanoTime();

		// code

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mowing.out")));
		BufferedReader br = new BufferedReader(new FileReader("mowing.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int l = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int startrow = Integer.parseInt(st.nextToken());
		int startcol = Integer.parseInt(st.nextToken());

		/*
		 * initialize lawn
		 */
		String[][] oglawn = new String[l][w];
		String[][] biglawn = new String[l][w];
		boolean lawn[][] = new boolean[l][w];
		for (int i = 0; i < l; i++) {

			String[] s = br.readLine().split(" ");
			biglawn[i] = s;
			oglawn[i] = s.clone();
			for (int j = 0; j < w; j++) {
				if (s[j].equals("."))
					lawn[i][j] = true;
			}
		}

		/*
		 * set up boolean matrix of same size, with patch center indices reporting 1 or
		 * 0 if a mower can go on them.
		 */
		int[][] adj = new int[l][w];
		// int counter = 0;
		for (int j = 1; j < l - 1; j++) {
			for (int i = 1; i < w - 1; i++) {
				if (patchclear(j, i, lawn)) {
					adj[j][i] = 1;
				}
			}
		}

		fill(startrow, startcol, adj, biglawn);
		printmat(oglawn);
		System.out.println("********************************************************");
		printmat(biglawn);
		long endTime = System.nanoTime();
		System.out.println("Took " + (endTime - startTime) / (1e6) + " ms");

	}

	/*
	 * floodfill
	 */
	public static void fill(int i, int j, int[][] avail, String[][] lawn) {
		if (i == 0 || j == 0 || i == lawn.length || j == lawn[0].length || avail[i][j] == 2 || avail[i][j] == 0) {
			return;
		} else {
			avail[i][j] = 2;
			lawn[i - 1][j - 1] = "c";
			lawn[i - 1][j] = "c";
			lawn[i - 1][j + 1] = "c";
			lawn[i][j - 1] = "c";
			lawn[i][j] = "c";
			lawn[i][j + 1] = "c";
			lawn[i + 1][j - 1] = "c";
			lawn[i + 1][j] = "c";
			lawn[i + 1][j + 1] = "c";

			fill(i + 1, j, avail, lawn);
			fill(i - 1, j, avail, lawn);
			fill(i, j + 1, avail, lawn);
			fill(i, j - 1, avail, lawn);
		}
	}

	/*
	 * returns whether a square 9 area patch with center r, c is free of obstacles.
	 */
	public static boolean patchclear(int r, int c, boolean[][] lawn) {
		for (int i = r - 1; i <= r + 1; i++) {
			for (int j = c - 1; j <= c + 1; j++) {

				if (lawn[i][j] == false) {

					return false;
				}
			}
		}
		return true;
	}

	public static void printmat(String[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void printmat2(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
