package tree.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	private Map<Character, TrieNode> children = new HashMap<>();
	private int times = 0;
	private boolean isTerminal = false;

	public TrieNode() {
	}

	public TrieNode(String word) {
		if (word.length() == 0) {
			times++;
			this.setTerminal(true);
		} else {
			addWord(word);
		}
	}

	public void addWord(String word) {
		if (word.length() > 0) {
			times++;
			Character character = word.charAt(0);
			if (getChildren().containsKey(character)) {
				getChildren().get(character).addWord(word.substring(1));
			} else {
				getChildren().put(character, new TrieNode(word.substring(1)));
			}
		}
	}

	/**
	 * Looks for prefix
	 * 
	 * @param prefix
	 * @return
	 */
	public boolean contains(String prefix) {
		return contains(this, prefix);
	}

	private boolean contains(TrieNode root, String prefix) {
		if (root == null) {
			return false;
		}
		if (prefix.length() == 0) {
			return true;
		}
		return contains(root.getChildren().get(prefix.charAt(0)), prefix.substring(1));

	}

	public int countPrefix(String prefix) {
		return countPrefix(this, prefix);
	}

	private int countPrefix(TrieNode trieNode, String prefix) {
		if (prefix.length() == 0) {
			return trieNode.times;
		}
		char c = prefix.charAt(0);
		if (trieNode.getChildren().containsKey(c)) {
			return countPrefix(trieNode.getChildren().get(c), prefix.substring(1));
		}
		return 0;
	}

	public boolean isTerminal() {
		return isTerminal;
	}

	public void setTerminal(boolean isTerminal) {
		this.isTerminal = isTerminal;
	}

	public Map<Character, TrieNode> getChildren() {
		return children;
	}

	public void setChildren(Map<Character, TrieNode> children) {
		this.children = children;
	}
}
