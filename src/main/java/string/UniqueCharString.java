package string;

/**
 * 
 *
 */
public class UniqueCharString {

	public static void main(String[] args) {
		System.out.println(1 << 60);
		System.out.println(isUniqueCharBit("abc"));
	}

	/**
	 * 
	 * @param str
	 * @return true if all chars of str are different
	 */
	public static boolean uniqueCharStr(String str) {
		if (str == null || str.length() == 0) {
			return true;
		}
		String dif = "";
		for (Character c : str.toCharArray()) {
			if (dif.contains(c.toString())) {
				return false;
			}
			dif += c;
		}
		return true;
	}

	public static boolean isUniqueChar(String str) {
		if (str.length() > 128) {
			return false;
		}
		boolean[] memo = new boolean[128];
		for (int i = 0; i < str.length(); i++) {
			if (memo[str.charAt(i)]) {
				return false;
			}
			memo[str.charAt(i)] = true;
		}
		return true;
	}

	/**
	 * 
	 * @param str
	 *            "a" to "z" only
	 * @return
	 */
	public static boolean isUniqueCharBit(String str) {
		int check = 0;
		for (int i = 0; i < str.length(); i++) {
			// subtract 'a' because of the range of the binary shift, otherwise
			// would be necessary to use more than one int
			int value = str.charAt(i) - 'a';
			if ((check & (1 << value)) > 0) {
				return false;
			}
			check |= 1 << value;
		}
		return true;

	}

}
