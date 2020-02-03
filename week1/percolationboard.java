import java.util.LinkedList;
import java.util.Random;

public class percolationboard {
	static Random r = new Random();

	static class ij {
		public int i;
		public int j;

		public ij(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	private int n;
	private LinkedList<ij> ijlist;
	private boolean[][] board;
	private QuickUnion nodes;
	private double totalspots, filledspots;
	private boolean printboard, compress;

	public percolationboard(int n, boolean printboard, boolean compress) {

		this.n = n;
		this.printboard = printboard;
		this.compress = compress;

	}

	private void init() {
		ijlist = new LinkedList<ij>();
		board = new boolean[n][n];
		if (compress)		
		{
			nodes = new QuickUnionPathCompression(n * n + 2);
		}
		else
		{
			nodes = new QuickUnionNoCompression(n*n+2);
		}
		totalspots = n * n;
		filledspots = 0;
	}

	public void fill() {
		init();
		/*
		 * filling the coordinate list with all unused coordinates of board
		 */
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ijlist.add(new ij(i, j));
			}

		}
		while (nodes.connected(0, n * n + 1) == false && ijlist.size() != 0) {

			ij pair = generate(ijlist);
			filledspots++;
			int rowfill = pair.i;
			int colfill = pair.j;
			board[rowfill][colfill] = true;

			int nodeIndex = rowfill * (n) + colfill + 1;
			int nodeIndexLeft = rowfill * n + colfill;
			int nodeIndexRight = rowfill * n + colfill + 2;
			int nodeIndexUp = (rowfill - 1) * n + colfill + 1;
			int nodeIndexDown = (rowfill + 1) * n + colfill + 1;

			if (rowfill == 0) {
				nodes.merge(nodeIndex, 0);

			}
			if (rowfill == n - 1) {
				nodes.merge(nodeIndex, n * n + 1);

			}
			if (rowfill != 0) {
				if (board[rowfill - 1][colfill] == true)
					nodes.merge(nodeIndex, nodeIndexUp);
			}
			if (rowfill != n - 1) {
				if (board[rowfill + 1][colfill] == true)
					nodes.merge(nodeIndex, nodeIndexDown);
			}
			if (colfill != n - 1) {
				if (board[rowfill][colfill + 1] == true)
					nodes.merge(nodeIndex, nodeIndexRight);
			}
			if (colfill != 0) {
				if (board[rowfill][colfill - 1] == true)
					nodes.merge(nodeIndex, nodeIndexLeft);
			}

		}
		if (printboard) {

			printmat(board);
			System.out.println();
		}
	}

	private static ij generate(LinkedList<ij> set) {
		ij x = set.get(r.nextInt(set.size()));
		set.removeFirstOccurrence(x);
		return x;

	}

	public static void printmat(boolean[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print((matrix[i][j]) ? "*" : "O");
			}
			System.out.println();
		}
	}

	public double getp() {
		return filledspots / totalspots;
	}
}
