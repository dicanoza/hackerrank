package cipher;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/cipher
 *
 */
public class Cipher {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int shifts = in.nextInt();
		String str = in.next();
		in.close();
		char[] original = str.substring(shifts - 1).toCharArray();
		int xor = 0;
		for (int i = original.length - 2; i >= 0; i--) {
			if (i + shifts - 1 < original.length - 1 && original[i + shifts] == '1') {
				xor--;
			}
			if (original[i + 1] == '1') {
				xor++;
			}
			int orig = Math.abs('0' - original[i]);
			original[i] = ((xor % 2) ^ orig) == 1 ? '1' : '0';
		}
		System.out.println(new String(original));
	}
}
