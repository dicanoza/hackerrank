package range;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int t = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		int m = in.nextInt();
		int n = in.nextInt();

		int apples = 0;

		for (int apple_i = 0; apple_i < m; apple_i++) {
			int d = in.nextInt();
			if (d > 0) {
				int absD = Math.abs(a) + Math.abs(d);
				if (absD >= Math.abs(s) && absD <= Math.abs(t)) {
					apples++;
				}
			}

		}
		int oranges = 0;

		for (int orange_i = 0; orange_i < n; orange_i++) {
			int d = in.nextInt();
			if (d < 0) {
				int absD = Math.abs(b) - Math.abs(d);
				if (absD >= Math.abs(s) && absD <= Math.abs(t)) {
					oranges++;
				}
			}
		}
		System.out.println(apples);
		System.out.println(oranges);
	}
}
