package dynamic;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

public class Subset {
	public static void main(String[] args) {
		List<Integer> list = asList(1, 2, 3, 4);
		System.out.println(getSubsts(list, 0));
	}

	static List<List<Integer>> getSubsts(List<Integer> set, int index) {
		List<List<Integer>> allsubsets;
		if (set.size() == index) {
			allsubsets = new ArrayList<>();
			allsubsets.add(new ArrayList<>());
		} else {
			allsubsets = getSubsts(set, index + 1);
			List<List<Integer>> moreSubsets = new ArrayList<>();
			for (List<Integer> list : allsubsets) {
				List<Integer> newList = new ArrayList<>(list);
				newList.add(set.get(index));
				moreSubsets.add(newList);
			}
			allsubsets.addAll(moreSubsets);
		}
		return allsubsets;
	}
}
