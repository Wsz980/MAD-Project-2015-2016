package spelling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class GetWord {

	public GetWord() {
		
	}
	
    //
	//
	//
	
	public static List<WordBean> getWordBeanList(List<String> wordList) {

		String urlRootStr = "http://dictionary.reference.com/browse/";

		List<WordBean> wordBeanList = new ArrayList<WordBean>();

		for (String wordStr : wordList) {
			String urlStr = urlRootStr + wordStr;

			System.out.println(urlStr);

			List<String> mp3List = GetWebContent.getMp3URLList(urlStr);
			WordBean wordBean = new WordBean(wordStr, urlStr, mp3List);
			wordBeanList.add(wordBean);
		}
		return wordBeanList;
	}



}
