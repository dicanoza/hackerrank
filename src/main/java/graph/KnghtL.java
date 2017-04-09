package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/knightl-on-chessboard
 * 
 * @author Diógenes
 *
 */
public class KnghtL {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		Map<String, Integer> map = new HashMap<>();
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				String key = 0 + "," + 0;
				if (map.containsKey(key)) {
					System.out.print(map.get(key) + " ");
				} else {

					Map<String, Integer> board = new HashMap<>();
					key = 0 + "," + 0;
					board.put(key, 1);
					boolean found = false;
					List<Node> queue = adj(0, 0, i, j, n, 1);
					int index = 0;
					while (!found && index < queue.size()) {

						Node head = queue.get(index);
						key = head.x + "," + head.y;
						if (!board.containsKey(key)) {
							board.put(key, 1);
							if (head.x == n - 1 && head.y == n - 1) {
								System.out.print(head.count + " ");
								map.put(i + "," + j, head.count);
								found = true;
								break;
							}
							for (Node k : adj(head.x, head.y, i, j, n, head.count + 1)) {
								key = k.x + "," + k.y;
								if (!board.containsKey(key)) {
									queue.add(k);
								}

							}
						}
						index++;
					}
					if (!found) {
						map.put(i + "," + j, -1);
						System.out.print(-1 + " ");
					}
				}
			}
			System.out.println();
		}
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

		@Override
		public String toString() {

			return x + "," + y;
		}
	}

}
