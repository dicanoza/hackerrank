package string;

import java.util.Scanner;

/**
 * Valid string have the same amount of characters example aabb
 * 
 * @author Diógenes
 *
 */
public class ValidString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		sc.close();
		int[] memo = new int[128];
		for (char c : word.toCharArray()) {
			memo[c]++;
		}
		int k = 0;
		int chances = 0;
		for (int i = 0; i < memo.length; i++) {
			if (memo[i] > 0) {
				if (k == 0) {
					k = memo[i];
				} else {
					if (!(k > 2 && memo[i] == 1) && (memo[i] > k + 1 || memo[i] < k - 1 || chances > 1)) {
						System.out.print("NO");
						return;
					} else if (memo[i] > k || memo[i] < k) {
						chances++;
						if (chances > 1) {
							System.out.print("NO");
							return;
						}
					}
				}
			}
		}
		System.out.println("YES");

	}
}
