package findHackerrank;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		char[] hackerrank = "hackerrank".toCharArray();
		out: for (int a0 = 0; a0 < q; a0++) {
			int pos = 0;
			String s = in.next();
			for (char c : s.toCharArray()) {
				if (c == hackerrank[pos]) {
					pos++;
				}
				if (pos == hackerrank.length) {
					System.out.println("YES");
					continue out;
				}
			}
			System.out.println("NO");

		}
	}
}