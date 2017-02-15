package factors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		List<Integer> a = new ArrayList<>();
		int max = 0;
		for (int a_i = 0; a_i < n; a_i++) {
			int aux = in.nextInt();
			a.add(aux);
			if (aux > max) {
				max = aux;
			}
		}
		List<Integer> b = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		for (int b_i = 0; b_i < m; b_i++) {
			int aux = in.nextInt();
			b.add(aux);
			if (aux < min) {
				min = aux;
			}
		}

		int result = 0;

		for (int i = max; i <= min; i++) {
			boolean factor = true;
			for (Integer k : a) {
				if (i % k != 0) {
					factor = false;
					break;
				}
			}
			if (factor) {
				for (Integer k : b) {
					if (k % i != 0) {
						factor = false;
						break;
					}
				}
				if (factor) {
					result++;
				}
			}
		}
		System.out.println(result);
	}
}
