package fibonacci;

public class TopDownMemory {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(fibonacci(i));

		}
	}

	public static int fibonacci(int n) {
		return fibonacci(n, new int[n + 1]);
	}

	private static int fibonacci(int n, int[] memo) {

		if (n <= 1) {
			return n;
		}
		if (memo[n] == 0) {
			memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
		}
		return memo[n];

	}

}
