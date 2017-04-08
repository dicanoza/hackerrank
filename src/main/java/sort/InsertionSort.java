package sort;

import java.util.Scanner;

public class InsertionSort {

	public static void insertIntoSorted(int[] ar) {
		int c = ar[ar.length - 1];
		if (ar.length == 1) {
			return;
		}
		for (int i = ar.length - 1; i >= 0; i--) {
			if (i > 0 && ar[i - 1] > c) {
				ar[i] = ar[i - 1];
				printArray(ar);
			} else {
				ar[i] = c;
				printArray(ar);
				break;
			}

		}

	}

	/* Tail starts here */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
		}
		insertIntoSorted(ar);
		in.close();
	}

	private static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}
}