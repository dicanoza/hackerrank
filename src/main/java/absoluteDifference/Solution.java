package absoluteDifference;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		int min = Integer.MAX_VALUE;
		Arrays.sort(a);
		for (int i = 0; i < a.length - 1; i++) {
			int abs = Math.abs(a[i] - a[i + 1]);
			if (min > abs) {
				min = abs;
			}
		}
		System.out.println(min);
	}
}
