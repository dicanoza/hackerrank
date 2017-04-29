package string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/string-similarity
 * 
 * zFunction
 * 
 *
 */
public class SufixArray {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int q = 0; q < n; q++) {
			String s = in.next();
			long l = s.length();
			for (int i : zFunctionList(s)) {
				l += i;
			}

			System.out.println(l);
		}
		in.close();
	}

	static List<Integer> zFunctionList(String s) {
		int n = s.length();
		List<Integer> z = new ArrayList<>(s.length());
		z.add(0);// first index always zero
		for (int i = 1, r = 0, l = 0; i < n; i++) {
			z.add(0);// since it is using lists need to add a value each
						// interaction
			if (i <= r) {// check if i is inside the last interaction []
				z.set(i, Math.min(r - i + 1, z.get(i - l)));
			}
			// goes one by one checking for similarity
			while (i + z.get(i) < n && s.charAt(z.get(i)) == s.charAt(i + z.get(i))) {
				z.set(i, z.get(i) + 1);
			}
			// marks the boundaries of the interaction, if there was similarity
			if (i + z.get(i) - 1 > r) {
				l = i; // lower boundary [
				r = i + z.get(i) - 1; // upper boundary ]
			}
		}
		return z;
	}

	static int[] zFunction(String s) {
		int n = s.length();
		int[] z = new int[n];
		for (int i = 1, r = 0, l = 0; i < n; i++) {
			if (i <= r) {
				z[i] = Math.min(r - i + 1, z[i - l]);
			}
			while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
				z[i]++;
			}
			if (i + z[i] - 1 > r) {
				l = i;
				r = i + z[i] - 1;
			}
		}
		return z;
	}

}
