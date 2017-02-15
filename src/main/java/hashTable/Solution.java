package hashTable;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();

		Map<String, Integer> map = new HashMap<>();
		for (int magazine_i = 0; magazine_i < m; magazine_i++) {
			String s = in.next();
			Integer i = map.get(s);
			if (i != null) {
				i++;
				map.put(s, i);
			} else {
				map.put(s, 1);
			}

		}
		boolean yes = true;

		for (int ransom_i = 0; ransom_i < n; ransom_i++) {
			String s = in.next();
			Integer i = map.get(s);
			if (i == null || i.equals(0)) {
				yes = false;
				break;
			} else {
				i--;
				map.put(s, i);
			}
		}
		if (yes) {
			System.out.print("Yes");
		} else {
			System.out.print("No");
		}
	}
}
