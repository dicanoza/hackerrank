package string;

public class Palindrome {
	/**
	 * Checks the word from both ends to the center, if the both cursors are
	 * always the same the word is a palindrome. The complexity of this
	 * algorithm is O(n).
	 * 
	 * @param word
	 *            to be checked
	 * @return true if it is a palindrome
	 */
	public static boolean palindromeCheck(String word) {
		int length = word.length();
		for (int i = 0; i < length / 2; i++) {
			int k = length - i - 1;
			if (word.charAt(i) != word.charAt(k)) {
				return false;
			}
		}
		return true;
	}

}
