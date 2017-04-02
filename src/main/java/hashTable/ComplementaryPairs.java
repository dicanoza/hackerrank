package hashTable;

import java.util.HashMap;
import java.util.Map;

public class ComplementaryPairs {

	/**
	 * 
	 * To find the K-complementary Pairs I needed to read the array just once.
	 * The pair of the position it's being read will be either further or before
	 * in the array. Using a Map to store the past encounters, for each position
	 * it can check if the pair is at the Map, otherwise stores itself waiting
	 * for being found afterwards. Considering that
	 * {@link Map#put(Object, Object)} and {@link Map#get(Object)} execute in
	 * constant time, this algorithm is O(n).
	 * 
	 * @param arr
	 *            array of non repeating integers
	 * @param k
	 *            number to be used in for comparison
	 * @return count of complementary numbers
	 */
	public static int countKComplementary(int[] arr, int k) {
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			Integer complement = k - arr[i];
			Integer complementIndex = map.get(complement);
			if (complementIndex != null && complementIndex >= 0 && complementIndex != i) {
				count++;
			} else {
				map.put(arr[i], i);
			}
		}
		return count;
	}

}
