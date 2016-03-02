package spelling;

import java.util.List;

public class WordBean {

	private String word;
	private String wordURL;
	private List<String> mp3List;
		
	public WordBean(String word, String wordURL, List<String> mp3List) {
		super();
		this.word = word;
		this.wordURL = wordURL;
		this.mp3List = mp3List;
	}

	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	
	
	public String getWordURL() {
		return wordURL;
	}

	public void setWordURL(String wordURL) {
		this.wordURL = wordURL;
	}

	public List<String> getMp3List() {
		return mp3List;
	}
	public void setMp3List(List<String> mp3List) {
		this.mp3List = mp3List;
	}
	
	
}
