package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class KnghtLDFS {
	private static Map<String, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				String key = 0 + "," + 0;
				if (map.containsKey(key)) {
					System.out.print(map.get(key) + " ");
				} else {

					Map<String, Integer> board = new HashMap<>();
					key = 0 + "," + 0;
					board.put(key, 1);
					int found = search(new Node(0, 0, 0), i, j, n, board);
					if (found == 0) {
						map.put(i + "," + j, -1);
						System.out.print(-1 + " ");
					}
				}
			}
			System.out.println();
		}
	}

	public static int search(Node node, int i, int j, int n, Map<String, Integer> board) {
		String key = node.x + "," + node.y;
		board.put(key, 1);
		if (node.x == n - 1 && node.y == n - 1) {
			System.out.print(node.count + " ");
			map.put(i + "," + j, node.count);
			return 1;
		}
		int found = 0;
		for (Node k : adj(node.x, node.y, i, j, n, node.count + 1)) {
			key = k.x + "," + k.y;
			if (!board.containsKey(key)) {
				found += search(k, i, j, n, board);
			}

		}
		return found;
	}

	public static List<Node> adj(int line, int col, int i, int j, int n, int count) {
		List<Node> result = new ArrayList<>();
		if (line - i >= 0 && col + j < n) {
			result.add(new Node(line - i, col + j, count));
		}
		if (line - j >= 0 && col + i < n) {
			result.add(new Node(line - j, col + i, count));
		}
		if (col - i >= 0 && line + j < n) {
			result.add(new Node(line + j, col - i, count));
		}
		if (col - j >= 0 && line + i < n) {
			result.add(new Node(line + i, col - j, count));
		}
		if (line + i < n && col + j < n) {
			result.add(new Node(line + i, col + j, count));
		}
		if (line + j < n && col + i < n) {
			result.add(new Node(line + j, col + i, count));
		}
		if (line - i >= 0 && col - j >= 0) {
			result.add(new Node(line - i, col - j, count));
		}
		if (line - j >= 0 && col - i >= 0) {
			result.add(new Node(line - j, col - i, count));
		}
		return result;
	}

	public static class Node {
		int x;
		int y;
		int count;

		public Node(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}

}
