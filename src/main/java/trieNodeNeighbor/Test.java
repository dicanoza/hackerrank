package trieNodeNeighbor;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {
	public static void main(String[] args) {
		String letras = "ABCDEFGHIJKLMNOPQRSTUVYWXZ";
		// String letras = "ABCDE";
		int k = 600000;
		StringBuilder sb = new StringBuilder();
		sb.append(k);
		sb.append("\n");
		for (int i = 0; i < k; i++) {
			int n = ((Double) (Math.random() * 11)).intValue();
			for (int j = 0; j <= n; j++) {
				sb.append(letras.charAt(((Double) (Math.random() * letras.length())).intValue()));
			}
			sb.append(" ");
		}
		sb.append("\n");

		Path path = Paths.get("D:\\test.txt");
		try (BufferedWriter newBufferedWriter = Files.newBufferedWriter(path)) {
			newBufferedWriter.write(sb.toString());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
