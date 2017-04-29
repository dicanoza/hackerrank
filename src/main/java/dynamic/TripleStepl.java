package dynamic;

import java.util.Arrays;

public class TripleStepl {

	public static void main(String args[]) {
		int n = 10;
		System.out.println(countWays(n));
		System.out.println(countWays(n));
	}

	static int countWays(int n) {
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
	}

	static int countWaysMemo(int n) {
		int[] memo = new int[n + 1];
		Arrays.fill(memo, -1);
		return countWays(n, memo);
	}

	static int countWays(int n, int[] memo) {
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		if (memo[n] > -1) {
			return memo[n];
		}
		memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo) + countWays(n - 3, memo);
		return memo[n];
	}
}
