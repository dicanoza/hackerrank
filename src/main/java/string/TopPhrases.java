package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class TopPhrases {
	public static void main(String[] args) {
		TrieNode root = new TrieNode();
		Path path = Paths.get("D:\\test.txt");
		try (BufferedReader reader = Files.newBufferedReader(path)) {
			while (reader.ready()) {
				String line = reader.readLine();
				StringTokenizer st = new StringTokenizer(line, "\\|");
				while (st.hasMoreTokens()) {
					root.addWord(st.nextToken());
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		List<TrieNode> phrasesList = TrieNode.phrasesList;

		Collections.sort(phrasesList, new Comparator<TrieNode>() {
			@Override
			public int compare(TrieNode o1, TrieNode o2) {
				return o2.getTimes().compareTo(o1.getTimes());
			}
		});

		for (int i = 0; i < 10; i++) {
			System.out.println(phrasesList.get(i).printUpwards() + "  " + phrasesList.get(i).getTimes());
		}
	}

}

class TrieNode {
	static List<TrieNode> phrasesList = new ArrayList<>();

	private Map<Character, TrieNode> children = new HashMap<>();
	private Integer times = 0;
	private boolean isTerminal = false;
	private TrieNode father;
	private Character character;

	public TrieNode() {
	}

	public TrieNode(String word, TrieNode father, Character character) {
		this.father = father;
		this.character = character;
		if (word.length() == 0) {
			this.times++;
			this.setTerminal(true);
		} else {
			addWord(word);
		}
		phrasesList.add(this);
	}

	public void addWord(String word) {
		if (word.length() > 0) {
			Character character = word.charAt(0);
			if (getChildren().containsKey(character)) {
				getChildren().get(character).addWord(word.substring(1));
			} else {
				getChildren().put(character, new TrieNode(word.substring(1), this, character));
			}
		} else {
			this.times++;
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

	public int countWord(String word) {
		return countWord(this, word);
	}

	private int countWord(TrieNode trieNode, String word) {
		if (word.length() == 0) {
			System.out.println(trieNode.printUpwards());
			return trieNode.times;
		}
		char c = word.charAt(0);
		if (trieNode.getChildren().containsKey(c)) {
			return countWord(trieNode.getChildren().get(c), word.substring(1));
		}
		return 0;
	}

	public String printUpwards() {
		if (father != null) {
			return father.printUpwards() + this.character;
		}
		return this.character == null ? "" : this.character.toString();
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

	public Integer getTimes() {
		return times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}
}