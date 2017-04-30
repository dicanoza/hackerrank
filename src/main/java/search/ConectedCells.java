package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/connected-cell-in-a-grid
 *
 */
public class ConectedCells {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		int y = in.nextInt();
		int[][] matrix = new int[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				matrix[i][j] = in.nextInt();
			}
		}
		int max = 0;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				int count = 0;
				if (matrix[i][j] == 1) {
					matrix[i][j] = 2;
					// count++;
					List<int[]> queue = new ArrayList<>();
					queue.add(new int[] { i, j });
					while (!queue.isEmpty()) {
						int[] point = queue.remove(0);
						// adding adjacent
						count++;
						for (int k = -1; k < 2; k++) {
							for (int t = -1; t < 2; t++) {
								int row = point[0] + k;
								int cell = point[1] + t;
								if (row >= 0 & row < x & cell >= 0 & cell < y && matrix[row][cell] == 1) {
									queue.add(new int[] { row, cell });
									// marking read
									matrix[row][cell] = 2;
								}
							}
						}
					}
				}
				if (count > max) {
					max = count;
				}

			}
		}
		System.out.println(max);
		in.close();
	}

}
