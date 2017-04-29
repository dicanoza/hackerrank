package dynamic;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

	public static void main(String[] args) {
		System.out.println(getPerms("abc3"));
	}

	static List<String> getPerms(String str) {
		if (str == null) {
			return null;
		}
		List<String> permutations = new ArrayList<>();
		if (str.length() == 0) {
			permutations.add("");
			return permutations;
		}
		char first = str.charAt(0);// get first char
		String remaider = str.substring(1);// remove the first char
		List<String> words = getPerms(remaider);
		for (String word : words) {
			for (int j = 0; j <= word.length(); j++) {

				String s = insertCharAt(word, first, j);
				permutations.add(s);
			}
		}
		return permutations;
	}

	private static String insertCharAt(String word, char c, int j) {
		String start = word.substring(0, j);
		String end = word.substring(j);
		return start + c + end;
	}
}
