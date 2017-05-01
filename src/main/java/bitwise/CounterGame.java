package bitwise;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/counter-game
 *
 */
public class CounterGame {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int q = 0; q < t; q++) {
			BigInteger n = new BigInteger(in.next());
			long l;
			if ((n.and(n.subtract(new BigInteger("1"))).equals(new BigInteger("0")))) {
				l = n.divide(new BigInteger("2")).longValue();
			} else {
				l = n.subtract(new BigInteger("1").shiftLeft(n.bitLength() - 1)).longValue();
			}
			boolean louise = true;
			while (l > 1) {
				if ((l & (-1 * l)) == l) {
					l = l / 2;
				} else {
					l -= Long.highestOneBit(l);
				}

				louise = !louise;

			}
			if (louise) {
				System.out.println("Louise");
			} else {
				System.out.println("Richard");
			}
		}
		in.close();
	}
}
