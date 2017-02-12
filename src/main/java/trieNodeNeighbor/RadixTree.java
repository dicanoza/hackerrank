package trieNodeNeighbor;

import java.util.HashMap;
import java.util.Map;

public class RadixTree {

	Map<String, RadixTree> children = new HashMap<>();
	String prefix;
	boolean isTerminal;

	RadixTree() {
	}

	RadixTree(String word) {
		if (word.length() == 0) {
			isTerminal = true;
		}
		addWord(word);
	}

	public void addWord(String word) {
		if (word.length() > 0) {
			if (this.children.size() == 0) {
				this.children.put(word, new RadixTree(""));
			} else {
				String sub1 = word.substring(0, 1);
				String child = findChild(sub1);
				int breakIndex = child.length();

				if (word.startsWith(child) && !child.isEmpty()) {
					children.get(child).addWord(word.substring(breakIndex));

				} else {
					breakIndex = breakIndex(word, child);

					String newChild = word.substring(0, breakIndex);
					RadixTree newChildNode = new RadixTree(newChild);

					RadixTree oldNode = children.remove(child);

					newChildNode.children.put(child.substring(breakIndex), oldNode);
					newChildNode.children.put(word.substring(breakIndex), new RadixTree(word.substring(breakIndex)));

					children.put(newChild, newChildNode);

				}
			}

		}
	}

	private int breakIndex(String word, String child) {
		int min = Math.min(child.length(), word.length());
		for (int i = 0; i < min; i++) {
			if (child.charAt(i) != word.charAt(i)) {
				return i;
			}
		}
		return min;
	}

	private String findChild(String sub1) {
		String child = "";
		for (String s : children.keySet()) {
			if (s.startsWith(sub1)) {
				child = s;
				break;
			}
		}
		return child;
	}
}