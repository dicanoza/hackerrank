package birds;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] types = new int[n];
		int[] commons = new int[6];

		for (int types_i = 0; types_i < n; types_i++) {
			types[types_i] = in.nextInt();
			commons[types[types_i]]++;
		}
		int max = 0;
		int pos = 0;
		for (int i = 5; i > 1; i--) {
			if (commons[i] >= max) {
				max = commons[i];
				pos = i;
			}
		}
		System.out.println(pos);
	}
}
