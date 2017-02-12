package trieNodeNeighbor;

import java.util.Arrays;
import java.util.List;

public class RadixUtils {
	public static void main(String[] args) {
		List<String> input = Arrays.asList("s", "ss", "sss", "ssss", "sssss", "sssxss");

		RadixTree root = new RadixTree();
		for (String s : input) {
			root.addWord(s);
		}

	}

}
