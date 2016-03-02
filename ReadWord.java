package spelling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ReadWord {

    //
	//
	//
	
	public static List<String> readWordList(String inputFilename) {

		List<String> wordList = new ArrayList<String>();

		System.out.println("Load File: " + inputFilename);

		try {

			BufferedReader fin = new BufferedReader(new FileReader(inputFilename));
			// new FileReader("Data/20050303214200_ysb5-3.sgf"));

			// Reading input by lines:

			String s;

			String wordsStr = fin.readLine() + "\n";

			while ((s = fin.readLine()) != null) {
				wordsStr += s + "\n";
			}

			StringTokenizer st = new StringTokenizer(wordsStr, "\n");
			while (st.hasMoreTokens()) {
				wordList.add(st.nextToken());

			}

			fin.close();

			// System.out.println(fileList);
			// System.out.println("++++++++++++++++++++++++++++++");

			for (int ii = 0; ii < wordList.size(); ii++) {
				System.out.println(wordList.get(ii));
			}

		} catch (Exception e) {
			System.err.println("Read file ERROR");
		}

		return wordList;

	}
}
