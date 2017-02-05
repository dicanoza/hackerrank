package tree.trie;

import static java.util.Arrays.copyOfRange;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	private Map<Character, TrieNode> children = new HashMap<>();
	private boolean isTerminal = false;

	public TrieNode() {
	}

	public TrieNode(char[] word) {
		if (word.length == 0) {
			this.setTerminal(true);
		} else {
			addWord(word);
		}
	}

	public void addWord(char[] word) {
		Character character = word[0];
		if (getChildren().containsKey(character)) {
			getChildren().get(character).addWord(tail(word));
		} else {
			getChildren().put(character, new TrieNode(tail(word)));
		}
	}

	private char[] tail(char[] word) {
		char[] copy = new char[word.length - 1];
		System.arraycopy(word, 1, copy, 0, word.length - 1);
		return copy;
	}

	/**
	 * Looks for prefix
	 * 
	 * @param prefix
	 * @return
	 */
	public boolean contains(String prefix) {
		return contains(this, prefix.toCharArray());
	}

	private boolean contains(TrieNode root, char[] prefix) {
		if (root == null) {
			return false;
		}
		if (prefix.length == 0) {
			return true;
		}
		return contains(root.getChildren().get(prefix[0]), copyOfRange(prefix, 1, prefix.length));

	}

	public int countPrefix(String prefix) {
		if (this.contains(prefix)) {
			return countPrefix(this, prefix.toCharArray());
		} else {
			return 0;
		}
	}

	private int countPrefix(TrieNode trieNode, char[] prefix) {
		if (prefix.length == 0) {
			int sum = 0;
			if (trieNode.isTerminal) {
				sum++;
			}
			for (TrieNode node : trieNode.getChildren().values()) {
				sum += countPrefix(node, prefix);
			}
			return sum;
		}
		char c = prefix[0];
		if (trieNode.getChildren().containsKey(c)) {
			return countPrefix(trieNode.getChildren().get(c), copyOfRange(prefix, 1, prefix.length));
		}
		return 0;
	}

	public boolean isTerminal() {
		return isTerminal;
	}

	public void setTerminal(boolean isTerminal) {
		this.isTerminal = isTerminal;
	}

	public void addWord(String s) {
		addWord(s.toCharArray());

	}

	public Map<Character, TrieNode> getChildren() {
		return children;
	}

	public void setChildren(Map<Character, TrieNode> children) {
		this.children = children;
	}
}
