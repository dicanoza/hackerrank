package dynamic;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-array
 *
 */
public class Sherlock {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int k = 0; k < q; k++) {
			int size = in.nextInt();
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = in.nextInt();
			}
			int[] memoLeft = new int[arr.length + 1];
			int[] memoRight = new int[arr.length + 1];
			boolean equal = false;
			for (int i = 0; i < arr.length; i++) {
				if (calcSumLeft(arr, i - 1, memoLeft) == calcSumRight(arr, i + 1, memoRight)) {
					equal = true;
					break;
				}

			}
			if (equal) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

	}

	private static int calcSumLeft(int[] arr, int index) {

		return calcSumLeft(arr, index, new int[index + 1]);
	}

	public static int calcSumLeft(int[] arr, int index, int[] memo) {
		if (index < 0) {
			return 0;
		}
		if (memo[index] == 0) {
			memo[index] = arr[index] + calcSumLeft(arr, index - 1, memo);
		}
		return memo[index];
	}

	private static int calcSumRight(int[] arr, int index) {

		return calcSumRight(arr, index, new int[arr.length + 1]);
	}

	public static int calcSumRight(int[] arr, int index, int[] memo) {
		if (index >= arr.length) {
			return 0;
		}

		if (memo[index] == 0) {
			memo[index] = arr[index] + calcSumRight(arr, index + 1, memo);
		}
		return memo[index];
	}

}
