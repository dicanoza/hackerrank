package knightL;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	static int size;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		size = in.nextInt();

		Map<String, Integer> results = new HashMap<>();

		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size - 1; j++) {
				if (results.get(i + "" + j) != null) {
					System.out.println(results.get(i + "" + j));
					continue;
				}
				int count = countMoves(i, j);
				results.put(i + "" + j, count);
				results.put(j + "" + i, count);
			}
		}
	}

	private static int countMoves(int i, int j) {
		// TODO Auto-generated method stub
		return 0;
	}

}
