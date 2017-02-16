package repeatedString;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		long n = in.nextLong();
		int length = s.length();
		long times = n / length;
		int rest = (int) (n % length);
		int count = 0;
		int countResto = 0;
		for (char c : s.toCharArray()) {
			if (c == 'a') {
				count++;
			}
		}
		String resto = s.substring(0, rest);
		for (char c : resto.toCharArray()) {
			if (c == 'a') {
				countResto++;
			}
		}

		System.out.print(times * count + countResto);

	}
}
