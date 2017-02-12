package trieNodeNeighbor;

import static java.util.Arrays.asList;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Solution {
	static Map<String, TrieNode> nodeMap = new HashMap<>();

	public static void main(String[] args) {
		// Scanner in = new Scanner(System.in);
		int n = 0; // in.nextInt();
		Collection<String> list = new TreeSet<>();
		TrieNode root = new TrieNode();

		//
		Path path = Paths.get("D:\\test.txt");
		try {
			BufferedReader reader = Files.newBufferedReader(path);
			n = new Integer(reader.readLine());
			list.addAll(asList(reader.readLine().split(" ")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//

		// for (int s_i = 0; s_i < n; s_i++) {
		// list.add(in.next());
		// }

		// in.close();

		System.out.println(list.size());

		long currentTimeMillis = System.currentTimeMillis();

		list.stream().forEach(x -> root.addWord(x));

		// for (String str : list) {
		// root.addWord(str);
		// }

		System.out.println(System.currentTimeMillis() - currentTimeMillis);

		Collection<String> removed = new TreeSet<>();

		List<String> listS = new ArrayList<>(list);

		int ret = 0;
		for (int i = list.size() - 1; i >= 0; i--) {
			String s = listS.get(i);
			if (!removed.contains(s)) {
				TrieNode trieNode = nodeMap.get(s);
				if (trieNode.neighbor != null) {
					String original = trieNode.neighbor.original;
					removed.add(original);
				}
				ret += count(s);
			}
		}
		System.out.println(System.currentTimeMillis() - currentTimeMillis);
		System.out.println(ret);
	}

	static int count(String s) {
		int result = 0;
		for (char c : s.toCharArray()) {
			result += c;
		}
		return result;
	}

	static class TrieNode {
		private Map<Character, TrieNode> children = new HashMap<>();
		private boolean isTerminal = false;
		private String original;
		private int maxLength = Integer.MAX_VALUE;

		TrieNode neighbor;
		List<TrieNode> neighbors = new ArrayList<>();

		public TrieNode() {
		}

		public TrieNode(String word, String original, TrieNode neighbor) {
			if (word.length() == 0) {
				nodeMap.put(original, this);
				this.original = original;
				this.setTerminal(true);
				resolveNeighbors(this, neighbor);

			} else {
				addWord(word, original, neighbor);
			}
		}

		private void resolveNeighbors(TrieNode local, TrieNode neighbor) {
			if (neighbor != null) {
				if (neighbor.maxLength >= local.original.length()) {
					neighbor.neighbors.add(local);
					neighbor.maxLength = local.original.length();
					local.neighbor = neighbor;
				}
			}

		}

		public void addWord(String word) {
			addWord(word, word, null);
		}

		public void addWord(String word, String original, TrieNode neighbor) {
			if (word.length() > 0) {
				Character character = word.charAt(0);
				if (getChildren().containsKey(character)) {
					TrieNode trieNode = getChildren().get(character);
					if (trieNode.isTerminal) {
						trieNode.addWord(word.substring(1), original, trieNode);

					} else {
						trieNode.addWord(word.substring(1), original, neighbor);
					}
				} else {
					getChildren().put(character, new TrieNode(word.substring(1), original, neighbor));
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

}