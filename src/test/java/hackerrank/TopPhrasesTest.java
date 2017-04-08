package hackerrank;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

import string.TopPhrases;

public class TopPhrasesTest {

	@Test
	public void topPhrasesTest() throws URISyntaxException {
		List<String> topPhrases = TopPhrases.topPhrases(10,
				Paths.get(this.getClass().getClassLoader().getResource("topPhraseTest1.txt").toURI()));

		assertEquals(topPhrases.size(), 10);
		assertEquals(topPhrases.get(0), "Indigo:6");

	}

	@Test
	public void topPhrasesTest2() throws URISyntaxException {
		List<String> topPhrases = TopPhrases.topPhrases(10,
				Paths.get(this.getClass().getClassLoader().getResource("topPhraseTest2.txt").toURI()));
		assertEquals(topPhrases.size(), 10);
		assertEquals(topPhrases.get(0), "Pink:14112");

	}

	@Test
	public void topPhrasesTest3() throws URISyntaxException {
		List<String> topPhrases = TopPhrases.topPhrases(1000,
				Paths.get(this.getClass().getClassLoader().getResource("topPhraseTest3.txt").toURI()));

		assertEquals(topPhrases.size(), 1000);
		assertEquals(topPhrases.get(0),
				"Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem. Fusce consequat.:418");

	}

}
