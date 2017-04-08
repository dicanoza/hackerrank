package bitManipulation;

/**
 * Consider an array of integers, , where all but one of the integers occur in
 * pairs. In other words, every element in occurs exactly twice except for one
 * unique element.
 * 
 * Given , find and print the unique element.
 * 
 * Input Format
 * 
 * The first line contains a single integer, , denoting the number of integers
 * in the array. The second line contains space-separated integers describing
 * the respective values in .
 * 
 * 
 */
public class Solution {

	public static void main(String[] args) {
		// Scanner in = new Scanner(System.in);
		// int n = in.nextInt();
		// int a[] = new int[n];
		// for (int a_i = 0; a_i < n; a_i++) {
		// a[a_i] = in.nextInt();
		// }
		System.out.println(lonelyInteger(new int[] { 2, 0, 1, 1, 0 }));
	}

	public static int lonelyInteger(int[] a) {
		int value = 0;

		for (int i : a) {

			value ^= i;
		}
		return value;
	}
}