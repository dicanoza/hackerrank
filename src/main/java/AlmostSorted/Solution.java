package AlmostSorted;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		List<Integer> elements = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			elements.add(scanner.nextInt());
		}

		int pos = 1;

		int swap = 0;
		int reverse = 0;
		String swapString = "";
		String reverseString = "";
		boolean rev = false;

		Integer buffer = elements.get(0);
		while (pos < n) {
			if (!rev) {
				buffer = pos == 1 ? 0 : elements.get(pos - 2);
			}

			boolean edge = pos == n - 1;
			if (!rev && elements.get(pos - 1) > elements.get(pos)
					&& (edge || elements.get(pos) < elements.get(pos + 1))) {
				swap++;
				swapString += pos + " " + (pos + 1);
				if (!edge && elements.get(pos - 1) > elements.get(pos + 1)) {
					swap++;
				}

			} else if (rev || (elements.get(pos - 1) > elements.get(pos)
					&& (edge || elements.get(pos) > elements.get(pos + 1)))) {

				if (!rev) {
					buffer = elements.get(pos);
					rev = true;
					reverseString += pos + " ";
					reverse++;
				}
				if (edge || elements.get(pos + 1) > buffer) {
					rev = false;
					elements.set(pos, buffer);
					reverseString += pos + 1 + " ";
				}

			}
			pos++;

		}
		if (swap == 0 && reverse == 0) {
			System.out.println("yes");
		} else if (swap == 1 && reverse == 0) {
			System.out.println("yes");
			System.out.println("swap " + swapString);
		} else if (reverse == 1 && swap == 0) {
			System.out.println("yes");
			System.out.println("reverse " + reverseString);
		} else {
			System.out.println("no");
		}

	}

}
