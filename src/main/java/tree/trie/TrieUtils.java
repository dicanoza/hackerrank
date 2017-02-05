package tree.trie;

import static java.util.Arrays.asList;

import java.util.List;

public class TrieUtils {
	public static void main(String[] args) {
		List<String> input = asList("abc", "abcd", "agj", "abcdji");

		TrieNode root = new TrieNode();
		for (String s : input) {
			root.addWord(s);
		}
		System.out.println(root.countPrefix("ab"));
		System.out.println(root.contains("abcdji"));
	}

}
