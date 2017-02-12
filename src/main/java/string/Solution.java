package string;

import static java.util.Arrays.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static int numberNeeded(String first, String second) {
		char[] firstArray = first.toCharArray();
		char[] secondArray = second.toCharArray();

		sort(firstArray);

		int ret = 0;

		for (int i = 0; i < firstArray.length; i++) {
			char charAt = firstArray[i];
			sort(secondArray);
			int binarySearch = Arrays.binarySearch(secondArray, charAt);
			if (binarySearch < 0) {
				ret++;
			} else {
				secondArray[binarySearch] = ' ';
				firstArray[i] = ' ';
			}
		}

		for (char c : secondArray) {
			if (c != ' ') {
				ret++;
			}
		}

		return ret;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		System.out.println(numberNeeded(a, b));
	}
}
