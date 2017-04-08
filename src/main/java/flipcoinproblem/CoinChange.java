package flipcoinproblem;

class CoinChange {
	static long countWays(int coins[], int m, int n) {
		long[] table = new long[n + 1];
		table[0] = 1;
		for (int i = 0; i < m; i++) {
			for (int j = coins[i]; j <= n; j++) {
				table[j] += table[j - coins[i]];
			}
		}

		return table[n];
	}

	public static void main(String args[]) {
		int arr[] = { 2, 3, 5, 6 };
		int m = arr.length;
		int n = 10;
		System.out.println(countWays(arr, m, n));
	}
}