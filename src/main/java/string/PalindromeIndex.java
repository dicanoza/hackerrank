package string;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/palindrome-index
 */
public class PalindromeIndex {

    static int palindromeIndex(String s) {
        int length = s.length();
        int result = -1;
        int aux = -1;
        for (int i = 0, j = length - 1; i < length / 2 && j >= length / 2; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                if (result != -1) {
                    return aux;
                }
                if (s.charAt(i + 1) == s.charAt(j)) {
                    result = i;
                    aux = j;
                    i++;
                } else if (s.charAt(i) == s.charAt(j - 1)) {
                    result = j;
                    aux = i;
                    j--;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            String s = in.next();
            int result = palindromeIndex(s);
            System.out.println(result);
        }
    }
}