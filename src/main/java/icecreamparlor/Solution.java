package icecreamparlor;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/icecream-parlor
 * 
 * @author Diógenes
 *
 */
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int q = 0; q < t; q++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int[] memo = new int[n];
			for (int i = 0; i < n; i++) {
				memo[i] = sc.nextInt();
			}
			for (int i = 0; i < n; i++) {
				int k = m - memo[i];
				for (int j = i + 1; j < n; j++) {
					if (k == memo[j]) {
						System.out.println(++i + " " + ++j);
						break;
					}
				}
			}
		}
		sc.close();

	}
}