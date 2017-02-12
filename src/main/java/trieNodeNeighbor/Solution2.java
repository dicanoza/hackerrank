package trieNodeNeighbor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution2 {
	static Map<String, RadixTree> nodeMap = new HashMap<>();
	static Map<String, Integer> countMap = new HashMap<>();
	static Map<String, String> neighborMap = new HashMap<>();
	static int result = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Collection<String> list = new TreeSet<>();
		RadixTree root = new RadixTree();

		//
		// Path path = Paths.get("D:\\test.txt");
		// try {
		// BufferedReader reader = Files.newBufferedReader(path);
		// n = new Integer(reader.readLine());
		// list.addAll(asList(reader.readLine().split(" ")));
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//

		for (int s_i = 0; s_i < n; s_i++) {
			root.addWord(in.next());
		}

		in.close();

		// System.out.println(list.size());

		// long currentTimeMillis = System.currentTimeMillis();

		// list.stream().forEach(x -> root.addWord(x));

		// for (String str : list) {
		// root.addWord(str);
		// }

		// System.out.println(System.currentTimeMillis() - currentTimeMillis);

		Map<String, String> removed = new HashMap<>();

		List<String> listS = new ArrayList<>(list);

		int ret2 = 0;
		removed = new HashMap<>();
		for (int i = list.size() - 1; i >= 0; i--) {
			String s = listS.get(i);
			if (removed.get(s) == null) {
				String string = neighborMap.get(s);
				if (string != null) {
					removed.put(string, string);
				}
				ret2 += countMap.get(s);
			}
		}

		// System.out.println(System.currentTimeMillis() - currentTimeMillis);
		System.out.println(ret2);
	}

	static int count(String s) {
		int result = 0;
		for (char c : s.toCharArray()) {
			result += c;
		}
		return result;
	}

	static class RadixTree {

		private Map<String, RadixTree> children = new HashMap<>();
		private boolean isTerminal;
		private int maxLength = Integer.MAX_VALUE;
		private RadixTree neighbor;
		private String original;
		private int count = 0;

		RadixTree() {
		}

		RadixTree(String word, String original, RadixTree neighbor) {
			if (word.length() == 0) {
				this.setTerminal(true);
				this.setOriginal(original);
				this.count = count(original);
				resolveNeighbors(this, neighbor);
				nodeMap.put(original, this);
				countMap.put(original, this.count);
				if (this.neighbor != null) {
					neighborMap.put(original, this.neighbor.original);
				}
			}
			addWord(word, original, neighbor);
		}

		public void addWord(String word) {
			addWord(word, word, null);

		}

		public void addWord(String word, String original, RadixTree neighbor) {
			if (word.length() > 0) {
				if (this.isTerminal()) {
					neighbor = this;
				}

				if (this.getChildren().size() == 0) {
					this.getChildren().put(word, new RadixTree("", original, neighbor));
				} else {

					String child = findChild(word.charAt(0));
					int breakIndex = child.length();

					if (word.startsWith(child) && !child.isEmpty()) {
						String substring = word.substring(breakIndex);
						RadixTree radixTree = getChildren().get(child);
						if (radixTree.isTerminal()) {
							radixTree.addWord(substring, original, radixTree);
						} else {
							radixTree.addWord(substring, original, neighbor);
						}

					} else {
						if (!child.isEmpty()) {

							breakIndex = breakIndex(word, child);

							String newChild = word.substring(0, breakIndex);
							RadixTree newChildNode = new RadixTree();

							RadixTree oldNode = getChildren().remove(child);

							newChildNode.getChildren().put(child.substring(breakIndex), oldNode);
							newChildNode.getChildren().put(word.substring(breakIndex),
									new RadixTree("", original, neighbor));

							newChildNode.count = count(newChild);
							getChildren().put(newChild, newChildNode);
						} else {
							getChildren().put(word, new RadixTree("", original, neighbor));
						}

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

		private String findChild(char sub1) {
			for (String s : getChildren().keySet()) {
				if (s.charAt(0) == sub1) {
					return s;
				}
			}
			return "";
		}

		private void resolveNeighbors(RadixTree local, RadixTree neighbor) {
			if (neighbor != null) {
				if (neighbor.getMaxLength() >= local.getOriginal().length()) {
					neighbor.setMaxLength(local.getOriginal().length());
					local.neighbor = neighbor;
				}
			}

		}

		public boolean isTerminal() {
			return isTerminal;
		}

		public void setTerminal(boolean isTerminal) {
			this.isTerminal = isTerminal;
		}

		public Map<String, RadixTree> getChildren() {
			return children;
		}

		public void setChildren(Map<String, RadixTree> children) {
			this.children = children;
		}

		public int getMaxLength() {
			return maxLength;
		}

		public void setMaxLength(int maxLength) {
			this.maxLength = maxLength;
		}

		public String getOriginal() {
			return original;
		}

		public void setOriginal(String original) {
			this.original = original;
		}

	}
}