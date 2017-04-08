package hackerrank;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import string.Palindrome;

public class PalindromeTest {

	@Test
	public void palindromeTest() {
		assertTrue(Palindrome.palindromeCheck("1234321"));
		assertTrue(Palindrome.palindromeCheck("123321"));
		assertTrue(Palindrome.palindromeCheck("11"));
		assertTrue(Palindrome.palindromeCheck("1"));
		assertTrue(!Palindrome.palindromeCheck("12"));
		assertTrue(!Palindrome.palindromeCheck("1121"));

	}
}
