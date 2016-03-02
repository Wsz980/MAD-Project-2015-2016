package spelling;

import java.util.List;

public class AASpellingExam {

	public AASpellingExam(String inputFilename, String outputFilename) {

		List<String> wordList = ReadWord.readWordList(inputFilename);
			
		List<WordBean> wordBeanList = GetWord.getWordBeanList(wordList);

		String htmlStr = BuildHTML.getHtml(wordBeanList);

		Output.writeTofile(outputFilename, htmlStr);

	}


	public static void main(String[] args) {
		
		String dataPath = "data/spelling/data/";
		String htmlPath = "data/spelling/html/";

		
		String wordFilStr;

		// wordFilStr = "WS_20130122";
		wordFilStr = "20130521";
		//wordFilStr = "WT_20130128";

		String inputFile = dataPath + wordFilStr + ".txt";
		String outputFile = htmlPath + wordFilStr + ".html";

		AASpellingExam spellingExam = new AASpellingExam(inputFile, outputFile);

	}

}
