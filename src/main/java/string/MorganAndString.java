package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * https://www.hackerrank.com/challenges/morgan-and-a-string
 *
 */
public class MorganAndString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		for (int q = 0; q < cases; q++) {
			String str1 = sc.next();
			String str2 = sc.next();

			char[] memo1 = str1.toCharArray();
			char[] memo2 = str2.toCharArray();
			char[] result = new char[memo1.length + memo2.length];
			Map<String, Integer> diff = new HashMap<>();

			int k1 = 0;
			int k2 = 0;

			// condições especiais
			if (memo1.length == 0) {
				result = memo2;
				System.out.println(new String(result));
				continue;
			}
			if (memo2.length == 0) {
				result = memo1;
				System.out.println(new String(result));
				continue;
			}

			for (int i = 0; i < result.length; i++) {
				if (k1 >= memo1.length && k2 < memo2.length) {
					result[i] = memo2[k2];
					k2++;
				} else if (k2 >= memo2.length && k1 < memo1.length) {
					result[i] = memo1[k1];
					k1++;
				} else if (memo1[k1] == memo2[k2]) {

					int d = diff(memo1, k1, memo2, k2, diff);
					if (d > 0) {
						result[i] = memo1[k1];
						k1++;
					} else {
						result[i] = memo2[k2];
						k2++;
					}

				} else if (memo1[k1] < memo2[k2]) {
					result[i] = memo1[k1];
					k1++;
				} else if (memo2[k2] < memo1[k1]) {
					result[i] = memo2[k2];
					k2++;
				}

			}

			System.out.println(new String(result));
		}

		sc.close();
	}

	static int increment(char[] result, int i, char[] memo, int k, int times) {
		for (int j = 0; j < times; j++) {
			result[i] = memo[k];
			k++;
		}
		return k;

	}

	static int diff(char[] memo1, int k1, char[] memo2, int k2, Map<String, Integer> diff) {
		if (k1 < memo1.length && k2 < memo2.length) {
			if (memo2[k2] - memo1[k1] > 0) {
				return 1;
			} else if (memo2[k2] - memo1[k1] < 0) {
				return -1;
			} else {
				String token = k1 + "," + k2;
				Integer d = diff.get(token);

				if (d == null) {
					d = diff(memo1, k1 + 1, memo2, k2 + 1, diff);
					diff.put(token, d);
				}
				return d;
			}
		} else if (k1 < memo1.length && k2 >= memo2.length) {
			return 1;
		} else if (k2 < memo2.length && k1 >= memo1.length) {
			return -1;
		}
		return 1;

	}

}
