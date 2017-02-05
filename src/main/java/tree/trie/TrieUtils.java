package tree.trie;

import java.util.Arrays;
import java.util.List;

public class TrieUtils {
	public static void main(String[] args) {
		List<String> input = Arrays.asList("s", "ss", "sss", "ssss", "sssss");

		TrieNode root = new TrieNode();
		for (String s : input) {
			root.addWord(s);
		}
		System.out.println(root.countPrefix("s"));
		System.out.println(root.countPrefix("ss"));
	}

}
