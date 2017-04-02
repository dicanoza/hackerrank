package string;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopPhrases {

	/**
	 * I tried other ways of implement this solution, as using Trie or Map, but
	 * MapReduce is best approach, being faster and using less memory. Because
	 * of the framework implementation, is hard to say the complexity, but I
	 * would say it is less or equal than Trie, which is O(n) for insertion and
	 * then O(nLogN) for sorting.
	 * 
	 * The method is very straightforward, it reads the lines, splits the
	 * phrases, groups them for counting and than sort for the top phrases
	 * limiting for the parameter informed. At the end just transform into a
	 * list concatenating key and value of the map created before.
	 * 
	 * 
	 * @param limit
	 *            number of top phrases to be considered, call it with 100.000
	 *            to get up to 100.000 top phrases
	 * @param path
	 *            file to be processed
	 * @return list of the top phrases found plus the count of times it appears
	 *         "phrase:count"
	 */
	public static List<String> topPhrases(int limit, Path path) {

		List<String> list = new ArrayList<>();
		try (BufferedReader reader = Files.newBufferedReader(path)) {
			list = reader.lines().flatMap(x -> asList(x.split("\\|")).stream())
					.collect(groupingBy(Function.identity(), counting())).entrySet().stream()
					.sorted(new Comparator<Entry<String, Long>>() {

						@Override
						public int compare(Entry<String, Long> o1, Entry<String, Long> o2) {
							return o2.getValue().compareTo(o1.getValue());
						}

					}).limit(limit).map(x -> x.getKey() + ":" + x.getValue()).collect(Collectors.toList());
		} catch (IOException e) {
			// TODO add some logging system
			e.printStackTrace();
		}

		return list;
	}
}