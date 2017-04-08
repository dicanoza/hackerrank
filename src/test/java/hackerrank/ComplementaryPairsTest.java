package hackerrank;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import hashTable.ComplementaryPairs;

public class ComplementaryPairsTest {

	@Test
	public void test() {
		assertEquals(ComplementaryPairs.countKComplementary(new int[] { 12, 4, 5, -2, -5, 6 }, 10), 2);
		assertEquals(ComplementaryPairs.countKComplementary(new int[] { 12, 4, 5, -2, -5, 6 }, 0), 1);
		assertEquals(ComplementaryPairs.countKComplementary(new int[] { 0, 10, 2, 5, -2, -5, 6 }, 10), 1);
		assertEquals(ComplementaryPairs.countKComplementary(new int[] { 22, -32, -15, 5, -6 }, -10), 2);
	}

}
